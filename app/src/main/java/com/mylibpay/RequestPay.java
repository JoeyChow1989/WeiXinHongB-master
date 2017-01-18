package com.mylibpay;

/**
 * [类功能说明]
 *
 * @author pengyang
 * @version v 1.0.0 16/12/30 上午9:49 XLXZ Exp $
 * @email pengyang@xianglin.cn
 */
public class RequestPay {

    private String method;
    private String order_no;
    private String goods_name;
    private String order_amt;
    private String notify_url;
    private String custom;
    private String sign;
    private String mchid;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }



    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getOrder_amt() {
        return order_amt;
    }

    public void setOrder_amt(String order_amt) {
        this.order_amt = order_amt;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
