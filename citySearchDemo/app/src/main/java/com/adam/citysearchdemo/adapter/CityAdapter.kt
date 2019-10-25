package com.adam.citysearchdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.adam.citysearchdemo.R
import com.adam.citysearchdemo.bean.Basic
import com.adam.citysearchdemo.bean.City

import java.util.ArrayList
import java.util.jar.Attributes

/**
 * Created by adamDeng on 2019/10/23
 * Copyright © 2019年 . All rights reserved.
 */
class CityAdapter(private val context: Context, private val data: ArrayList<Basic>) :
    RecyclerView.Adapter<CityAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val name: TextView = itemView.findViewById(R.id.city_name)

    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.name.text= data[position].location+","+data[position].parent_city+","+data[position].admin_area+","+data[position].cnty



    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(context).inflate(R.layout.city_item, parent, false)
        return VH(itemView)
    }


}
