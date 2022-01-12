package com.example.rv_inside_rev_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rv_inside_rev_5.adapter.CustomAdapter
import com.example.rv_inside_rev_5.databinding.ActivityMainBinding
import com.example.rv_inside_rev_5.model.Member
import com.example.rv_inside_rev_5.model.MemberSub

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)

    }

    private fun initViews() {
        bin.recyclerviewMain.layoutManager = GridLayoutManager(this, 1)
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..30) {
            if (i % 5 == 0) {
                members.add(Member("Android", "$i", prepareMemberSub()))
            } else {
                members.add(Member("Android", "$i", ArrayList<MemberSub>()))
            }
        }
        return members
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this, members)
        bin.recyclerviewMain.adapter = adapter
    }

    private fun prepareMemberSub(): List<MemberSub> {
        val members = ArrayList<MemberSub>()

        for (i in 0..5) {
            members.add(MemberSub("Offline", "mode"))
        }
        return members
    }
}