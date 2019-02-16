package com.example.exam.api;

import com.example.exam.bean.Bean;
import com.example.exam.bean.FocusBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//创建 用于描述网络请求 的接口
public interface Apis {

    @POST("small/commodity/v1/findCommodityByKeyword")
    @FormUrlEncoded
    Call<Bean> show(@Field("name")String name,@Field("page")String page,@Field("count")String count);

    @GET("small/commodity/v1/findCommodityByKeyword")
    Call<Bean> shou(@Query("keyword")String name,@Query("page")int page, @Query("count")int count);

}
