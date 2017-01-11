package com.hb.net;

import com.data.bean.Result;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pc on 2016/12/27.
 */
public interface NoticeServerApi
{
    @GET("ispay")
    Observable<Result> getNotice(@Query("oid") String oid);
}
