package cn.swiftpass.spaycx.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.data.bean.Result;
import com.hb.net.RxService;
import com.hb.qx.URL;
import com.hb.qx.YqhyDialog1;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import cn.swiftpass.spaycx.R;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler
{

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private RelativeLayout mLayout;
    private TextView finishpay;
    private IWXAPI api;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_results);
        api = WXAPIFactory.createWXAPI(this, URL.APPID);//appid需换成商户自己开放平台appid
        api.handleIntent(getIntent(), this);

        finishpay = (TextView) findViewById(R.id.pay_finsh);
        finishpay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public void onReq(BaseReq req)
    {
    }

    @Override
    public void onResp(BaseResp resp)
    {
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX)
        {
            sp = getSharedPreferences("chatpage", MODE_PRIVATE);
            editor = sp.edit();

            // resp.errCode == -1 原因：支付错误,可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等
            // resp.errCode == -2 原因: 用户取消,无需处理。发生场景：用户不支付了，点击取消，返回APP
            if (resp.errCode == 0) // 支付成功
            {
                Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
                NoticeServer();
            } else
            {
                Toast.makeText(this, "取消支付" + resp.errCode + "test", Toast.LENGTH_SHORT)
                        .show();
                finish();
            }
        }
    }

    private void NoticeServer()
    {
        Toast.makeText(this, "----------oid----------:" + sp.getString("oid", ""), Toast.LENGTH_SHORT).show();

        RxService.getNoticeApi().getNotice(sp.getString("oid", ""))
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
                            //Toast.makeText(WXPayEntryActivity.this, "-------成功-------", Toast.LENGTH_SHORT).show();
                            editor.putInt("vip_" + sp.getString("typexxx", ""), 1);
                            editor.commit();
                        }
                    }
                });
    }
}