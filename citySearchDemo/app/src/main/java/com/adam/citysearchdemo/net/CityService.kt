package com.adam.citysearchdemo.net

import android.telecom.Call
import com.adam.citysearchdemo.bean.City
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by adamDeng on 2019/10/23
 * Copyright © 2019年 . All rights reserved.
 */
interface CityService {
    @GET("find")
    fun getCity(@Query("location") location: String, @Query("key") key: String): retrofit2.Call<City>
}