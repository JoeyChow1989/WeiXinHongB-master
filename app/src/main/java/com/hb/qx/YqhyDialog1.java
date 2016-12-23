package com.hb.qx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.data.bean.PayResult;
import com.hb.net.RxService;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class YqhyDialog1 extends PopupWindow
{
    private Context mActivity;
    private LinearLayout linearLayout;
    private Button button;
    private RadioButton zhifubao, weixin;
    private ImageView cancel;
    private TextView tv_prise;

    private boolean isZFB, isWX;
    String prise;

    //支付方式
    int paytype;
    private String transdata;

    public YqhyDialog1(Context activity, String prise)
    {
        mActivity = activity;
        this.prise = prise;
        initView();
    }

    public void initView()
    {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_share1, null);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.context_view1);
        button = (Button) rootView.findViewById(R.id.id_querenzhifu);
        zhifubao = (RadioButton) rootView.findViewById(R.id.id_checkbox_zhifubao);
        weixin = (RadioButton) rootView.findViewById(R.id.id_checkbox_weixin);
        cancel = (ImageView) rootView.findViewById(R.id.id_dialog_cancel1);
        tv_prise = (TextView) rootView.findViewById(R.id.id_share_prise);
        tv_prise.setText(prise + "元");

        zhifubao.setChecked(true);
        zhifubao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if (b)
                {
                    weixin.setChecked(false);
                } else
                {
                    weixin.setChecked(true);
                }
            }
        });

        weixin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if (b)
                {
                    zhifubao.setChecked(false);
                } else
                {
                    zhifubao.setChecked(true);
                }
            }
        });

        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                System.out.println("---------确认---------");
                if (weixin.isChecked())
                {
                    paytype = 10002;
                } else if (zhifubao.isChecked())
                {
                    paytype = 10006;
                }
                Pay(paytype);
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

    private void Pay(int paytype)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("merchantID", 100001);
            jsonObject.put("waresname", "test");
            jsonObject.put("cporderid", "00000000");
            jsonObject.put("price", "0.01");
            jsonObject.put("returnurl", "http://www.xiaoxiaopay.com");
            jsonObject.put("notifyurl", "http://www.xiaoxiaopay.com");
            jsonObject.put("paytype", paytype);
            jsonObject.put("ip", "0.0.0.0");
            transdata = jsonObject.toString();
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        RxService.getPayApi().getPay(transdata, "xxxxx", "RSA")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayResult>()
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
                    public void onNext(PayResult payResult)
                    {

                    }
                });
    }

    @Override
    public void dismiss()
    {
        super.dismiss();
    }
}
