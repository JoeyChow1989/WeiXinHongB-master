package com.mylibpay;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;

import com.switfpass.pay.MainApplication;
import com.switfpass.pay.bean.RequestMsg;
import com.switfpass.pay.utils.Util;

import org.json.JSONObject;

/**
 * [类功能说明]
 *
 * @author pengyang
 * @version v 1.0.0 16/12/30 上午9:46 XLXZ Exp $
 * @email pengyang@xianglin.cn
 */
public class Pay {

    public static int unifiedAppPay(final Activity act, final String appId, RequestPay requestPay) {



        if(Looper.myLooper() == Looper.getMainLooper()
                ){
            return -4;
        }

        String url = String.format("http://www.huayuinfinite.com/pay/wft_app/index.php?" +
                        "method=%s&" +
                        "order_no=%s&" +
                        "goods_name=%s&" +
                        "order_amt=%s&" +
                        "notify_url=%s&" +
                        "custom=%s&" +
                        "mchid=%s&" +
                        "sign=%s",
                requestPay.getMethod(),
                requestPay.getOrder_no(),
                requestPay.getGoods_name(),
                requestPay.getOrder_amt(),
                requestPay.getNotify_url(),
                requestPay.getCustom(),
                requestPay.getMchid(),
                requestPay.getSign()
        );

        try {
            byte[] buf = Util.httpGet(url);
            if (buf != null && buf.length > 0) {
                String content = new String(buf);
                Log.e("get server pay params:", content);
                final JSONObject json = new JSONObject(content);
                if (null != json && json.has("token_id")) {

                    if(act!=null){
                        act.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                RequestMsg msg = new RequestMsg();
                                msg.setTokenId(json.optString("token_id"));
                                msg.setTradeType(MainApplication.WX_APP_TYPE);
                                msg.setAppId(appId);// wx2a5538052969956e
                                com.switfpass.pay.activity.PayPlugin.unifiedAppPay(act, msg);
                            }
                        });
                    }

                    return 0;

                } else {
                    //handler.obtainMessage(1, "服务器返回错误");
                    return -1;
                }
            } else {
                //handler.obtainMessage(1, "服务器异常");
                return -2;
            }
        } catch (Exception e) {

            return -3;
        }


    }


}
