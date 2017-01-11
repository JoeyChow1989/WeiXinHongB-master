package com.hb.qx;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.data.bean.Result;
import com.hb.net.RxService;
import com.hb.tool.Sha_php;
import com.hf.ep.HFPAY;
import com.hf.ep.HFPAY_PayListener;

import gediaoshangpin.com.R;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class YqhyDialog1 extends PopupWindow
{
    private Activity mActivity;
    private LinearLayout linearLayout, linear_zhifubao, linear_weixin;
    private Button button;
    private RadioButton zhifubao, weixin;
    private ImageView cancel;
    private TextView tv_prise, tv_title;
    private String type;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private boolean isZFB, isWX;
    String prise;
    String oid;
    String title;
    String token;

    //支付方式
    public YqhyDialog1(Activity activity, String title, String prise, String type)
    {
        mActivity = activity;
        this.prise = prise;
        this.title = title;
        this.type = type;

        System.out.println("-------type------:" + type);
        initView();
    }

    public void initView()
    {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_share1, null);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.context_view1);
        linear_zhifubao = (LinearLayout) rootView.findViewById(R.id.id_linear_zhifubao);
        linear_weixin = (LinearLayout) rootView.findViewById(R.id.id_linear_weixin);
        button = (Button) rootView.findViewById(R.id.id_querenzhifu);
        tv_title = (TextView) rootView.findViewById(R.id.id_dialog_1_title);
        zhifubao = (RadioButton) rootView.findViewById(R.id.id_checkbox_zhifubao);
        weixin = (RadioButton) rootView.findViewById(R.id.id_checkbox_weixin);
        cancel = (ImageView) rootView.findViewById(R.id.id_dialog_cancel1);
        tv_prise = (TextView) rootView.findViewById(R.id.id_share_prise);
        tv_prise.setText(prise + "元");
        oid = String.valueOf(System.currentTimeMillis());

        sp = mActivity.getSharedPreferences("chatpage", mActivity.MODE_PRIVATE);
        editor = sp.edit();

        tv_title.setText(title);
        zhifubao.setChecked(true);

        linear_zhifubao.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (weixin.isChecked())
                {
                    zhifubao.setChecked(true);
                    weixin.setChecked(false);
                }
            }
        });

        linear_weixin.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (zhifubao.isChecked())
                {
                    weixin.setChecked(true);
                    zhifubao.setChecked(false);
                }
            }
        });


        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                System.out.println("---------确认---------");
                token = Sha_php.computeSha1OfString(oid + prise.replace(".", "") + "0" + "#@@@123AF!!");
                //token = Sha_php.computeSha1OfString(oid + "1" + "#@@@123AF!!");

                System.out.println("oid---------:" + oid);
                System.out.println("prise---------:" + Integer.parseInt(prise.replace(".", "") + "0"));
                System.out.println("token---------:" + token);

                System.out.println("-------prise double------" + Double.valueOf(prise));

                if (weixin.isChecked())
                {
                    // Toast.makeText(mActivity, "-------微信-----", Toast.LENGTH_SHORT).show();
                    PayService(oid, URL.qudao_num, prise.replace(".", "") + "0", "0", token);
                    // PayService(oid, URL.qudao_num, "1", "0", token);
                } else
                {
                    //Toast.makeText(mActivity, "-------支付宝-----", Toast.LENGTH_SHORT).show();
                    PayService(oid, URL.qudao_num, prise.replace(".", "") + "0", "1", token);
                    //PayService(oid, URL.qudao_num, "1", "1", token);
                }
            }
        });

        cancel.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dismiss();
            }
        });
        setContentView(rootView);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.MATCH_PARENT);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(false);
    }

    private void PayService(String orderm, String cid, String money, final String type, String token)
    {
        RxService.getOrderApi().getOrder(orderm, cid, money, type, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>()
                {
                    @Override
                    public void onCompleted()
                    {
                        System.out.println("-----onCompleted()-----");
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        System.out.println("e:" + e);
                    }

                    @Override
                    public void onNext(Result result)
                    {

                        System.out.println("result----:" + result.getResult());
                        if ("1".equals(result.getResult()))
                        {
                            if ("1".equals(type))
                            {
                                PayZhiFuBao();
                            } else if ("0".equals(type))
                            {
                                PayWeiXin();
                            }
                        }
                    }
                });
    }

    private void PayZhiFuBao()
    {
        doPay(0);
    }

    private void PayWeiXin()
    {
        doPay(1);
    }

    private void doPay(int t)
    {
        HFPAY.pay(mActivity, t, Integer.parseInt(prise.replace(".", "") + "0"), URL.XF_APPID, oid,
                new HFPAY_PayListener()
                {

                    @Override
                    public void payResult(int code)
                    {
                        if (code == 0)
                        {
                            // 支付成功
                            Toast.makeText(mActivity, "支付成功",
                                    Toast.LENGTH_SHORT).show();
                            NoticeServer();

                            dismiss();
                            editor.putInt("vip_" + type, 1);
                            editor.commit();

                        } else
                        {
                            // 支付失败
                            Toast.makeText(mActivity, "支付失败",
                                    Toast.LENGTH_SHORT).show();
                            dismiss();
                        }
                    }
                });
    }

    private void NoticeServer()
    {
        RxService.getNoticeApi().getNotice(oid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>()
                {
                    @Override
                    public void onCompleted()
                    {

                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onNext(Result result)
                    {
                        System.out.println("------:" + result.getResult());
                        if ("1".equals(result.getResult()))
                        {
                            //Toast.makeText(mActivity, "-------成功-----", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void dismiss()
    {
        oid = "";
        super.dismiss();
    }
}
