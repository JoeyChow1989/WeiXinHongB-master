package com.hb.net;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SkyEyesStion on 2016/2/26.
 */
public class RxService
{
    private static final String MAKEORDERBASETESTURL = "http://www.uku99.net/hb/";
    //private static OkHttpClient okHttpClient = new OkHttpClient();
//    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASETESTURL).client(okHttpClient)
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava适配器
//            .addConverterFactory(GsonConverterFactory.create())//Gson转换器
//            .build();

//    private static Retrofit retrofit_imgs = new Retrofit.Builder().baseUrl(BASETESTURL_IMGS).client(okHttpClient)
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava适配器
//            .addConverterFactory(GsonConverterFactory.create())//Gson转换器
//            .build();

//    public static <T> T createApi(Class<T> clazz)
//    {
//        return retrofit.create(clazz);
//    }

//    public static <T> T createApi_img(Class<T> clazz)
//    {
//        return retrofit_imgs.create(clazz);
//    }

    private static MakeOrderApi mOrderApi;
    private static NoticeServerApi mNoticeApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static MakeOrderApi getOrderApi()
    {
        if (mOrderApi == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(MAKEORDERBASETESTURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();

            mOrderApi = retrofit.create(MakeOrderApi.class);
        }
        return mOrderApi;
    }

    public static NoticeServerApi getNoticeApi()
    {
        if (mNoticeApi == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(MAKEORDERBASETESTURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();

            mNoticeApi = retrofit.create(NoticeServerApi.class);
        }
        return mNoticeApi;
    }
}
