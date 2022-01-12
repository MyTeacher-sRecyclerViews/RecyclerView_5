package com.example.rv_inside_rev_5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_inside_rev_5.R
import com.example.rv_inside_rev_5.model.MemberSub

class CustomSubAdapter(val context: Context, private val list: List<MemberSub>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view_sub,parent,false)
        return CustomViewSubHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }
    class CustomViewSubHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}