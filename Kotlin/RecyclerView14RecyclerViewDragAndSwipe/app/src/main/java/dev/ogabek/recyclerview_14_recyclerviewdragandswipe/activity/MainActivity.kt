package dev.ogabek.recyclerview_14_recyclerviewdragandswipe.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.R
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.adapter.MainAdapter
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.helper.SimpleItemTouchHelperCallBack
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.model.Member

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
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = MainAdapter(context, members as ArrayList<Member>)
        recyclerView.adapter = adapter
        val callback = SimpleItemTouchHelperCallBack(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..50) members.add(Member("$i"))
        return members
    }

}