package com.example.rv_inside_rev_5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_inside_rev_5.R
import com.example.rv_inside_rev_5.model.Member
import com.example.rv_inside_rev_5.model.MemberSub

class CustomAdapter(val context: Context, private val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM_VIEW = 0
        private const val TYPE_ITEM_LIST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (members[position].memberSub.isNotEmpty()) TYPE_ITEM_LIST else TYPE_ITEM_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_LIST) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return CustomListHolder(view)
        }
        val footer =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return CustomViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is CustomListHolder) {
            val recyclerView = holder.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

            val memberSub = member.memberSub
            refreshAdapter(recyclerView, memberSub)
        }

    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerview_item)
    }

    private fun refreshAdapter(recyclerView: RecyclerView, memberSubs: List<MemberSub>) {
        val adapter = CustomSubAdapter(context, memberSubs)
        recyclerView.adapter = adapter
    }

    class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}