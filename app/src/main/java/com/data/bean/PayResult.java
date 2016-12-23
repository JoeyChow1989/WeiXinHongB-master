package com.data.bean;

/**
 * Created by pc on 2016/12/23.
 */
public class PayResult
{
    private int resultCode;
    private String sign;
    private String signtype;

    private Info info;

    public int getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(int resultCode)
    {
        this.resultCode = resultCode;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getSigntype()
    {
        return signtype;
    }

    public void setSigntype(String signtype)
    {
        this.signtype = signtype;
    }

    public Info getInfo()
    {
        return info;
    }

    public void setInfo(Info info)
    {
        this.info = info;
    }

    public class Info{
        String payurl;
        String nonceStr;

        public String getPayurl()
        {
            return payurl;
        }

        public void setPayurl(String payurl)
        {
            this.payurl = payurl;
        }

        public String getNonceStr()
        {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr)
        {
            this.nonceStr = nonceStr;
        }
    }
}
