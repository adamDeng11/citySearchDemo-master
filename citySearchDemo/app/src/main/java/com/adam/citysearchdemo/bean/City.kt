package com.adam.citysearchdemo.bean

/**
 * Created by adamDeng on 2019/10/23
 * Copyright © 2019年 . All rights reserved.
 */
data class City(
    val HeWeather6: List<HeWeather6>
)

data class HeWeather6(
    val basic: List<Basic>,
    val status: String
)

data class Basic(
    val admin_area: String,
    val cid: String,
    val cnty: String,
    val lat: String,
    val location: String,
    val lon: String,
    val parent_city: String,
    val type: String,
    val tz: String
)