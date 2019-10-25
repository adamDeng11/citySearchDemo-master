package com.adam.citysearchdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adam.citysearchdemo.adapter.CityAdapter
import com.adam.citysearchdemo.bean.Basic
import com.adam.citysearchdemo.bean.City
import com.adam.citysearchdemo.net.CityService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.city_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result.response





class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var data:ArrayList<Basic>
    private lateinit var cityAdapter: CityAdapter
    private var retrofit = Retrofit.Builder()  //创建Retrofit实例
        .baseUrl("https://search.heweather.net/")    //这里需要传入url的域名部分
        .addConverterFactory(GsonConverterFactory.create()) //返回的数据经过转换工厂转换成我们想要的数据，最常用的就是Gson
        .build()   //构建实例
    private var service: CityService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        service = retrofit.create(CityService::class.java)
        data=ArrayList()
        searchView=findViewById(R.id.searchView)
        recyclerView=findViewById(R.id.recycleView_city)
        cityAdapter= CityAdapter(this,data)
        recyclerView.adapter=cityAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager=linearLayoutManager

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (!TextUtils.isEmpty(newText)) {
                    data.clear()
                    request(newText)


                } else {

                }
                return false
            }
        })


    }

    fun request(location:String){
        val call = service!!.getCity(location,"288367e25c264a1bb63aff12da05e278")
        call.enqueue(object :Callback<City>{
            override fun onResponse(call: Call<City>, response: Response<City>) {
                val bean = response.body()
                if (bean != null) {
                    data.addAll(bean.HeWeather6[0].basic)
                    cityAdapter.notifyDataSetChanged()
                }
               Log.i("你好，啊",data.toString())


            }

            override fun onFailure(call: Call<City>, t: Throwable) {
                Toast.makeText(this@MainActivity,"请检查网络",Toast.LENGTH_LONG).show()
            }
        })
    }

}
