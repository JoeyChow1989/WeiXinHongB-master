package com.data.bean;

/**
 * Created by pc on 2016/12/23.
 */
public class UserPay
{
    private int merchantID;
    private String waresname;
    private String cporderid;
    private float price;
    private String returnurl;
    private String notifyurl;
    private int paytype;

    public UserPay(int merchantID, String waresname, String cporderid, float price, String returnurl, String notifyurl, int paytype)
    {
        this.merchantID = merchantID;
        this.waresname = waresname;
        this.cporderid = cporderid;
        this.price = price;
        this.returnurl = returnurl;
        this.notifyurl = notifyurl;
        this.paytype = paytype;
    }

    public int getMerchantID()
    {
        return merchantID;
    }

    public void setMerchantID(int merchantID)
    {
        this.merchantID = merchantID;
    }

    public String getWaresname()
    {
        return waresname;
    }

    public void setWaresname(String waresname)
    {
        this.waresname = waresname;
    }

    public String getCporderid()
    {
        return cporderid;
    }

    public void setCporderid(String cporderid)
    {
        this.cporderid = cporderid;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getReturnurl()
    {
        return returnurl;
    }

    public void setReturnurl(String returnurl)
    {
        this.returnurl = returnurl;
    }

    public String getNotifyurl()
    {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl)
    {
        this.notifyurl = notifyurl;
    }

    public int getPaytype()
    {
        return paytype;
    }

    public void setPaytype(int paytype)
    {
        this.paytype = paytype;
    }
}
