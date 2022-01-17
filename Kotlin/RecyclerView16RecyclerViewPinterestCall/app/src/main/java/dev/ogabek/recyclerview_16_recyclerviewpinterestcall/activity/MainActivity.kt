package dev.ogabek.recyclerview_16_recyclerviewpinterestcall.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dev.ogabek.recyclerview_16_recyclerviewpinterestcall.R
import dev.ogabek.recyclerview_16_recyclerviewpinterestcall.adapter.MainAdapter
import dev.ogabek.recyclerview_16_recyclerviewpinterestcall.helper.SpacesItemDecoration
import dev.ogabek.recyclerview_16_recyclerviewpinterestcall.model.Member

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.rv_main_recycler_view)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val spacesItemDecoration = SpacesItemDecoration(10)
        recyclerView.addItemDecoration(spacesItemDecoration)

    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = MainAdapter(context, members as ArrayList<Member>)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..100) members.add(Member())
        return members
    }

}