package com.hb.net;

import com.data.bean.PayResult;
import com.data.bean.UserPay;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pc on 2016/12/23.
 */
public interface PayApi
{
    @POST("/order")
    Observable<PayResult> getPay(@Field("transdata") String transdata, @Field("sign") String sign, @Field("signtype") String signtype);
}
