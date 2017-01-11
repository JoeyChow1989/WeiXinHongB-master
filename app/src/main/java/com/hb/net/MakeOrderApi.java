package com.hb.net;

import com.data.bean.Result;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pc on 2016/12/27.
 */
public interface MakeOrderApi
{
    @FormUrlEncoded
    @POST("index")
    Observable<Result> getOrder(@Field("oid") String oid, @Field("cid") String cid, @Field("money") String money, @Field("type") String type, @Field("token") String token);
}
