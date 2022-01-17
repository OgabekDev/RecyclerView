package dev.ogabek.recyclerview_8_recyclerviewashorizontalllist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_8_recyclerviewashorizontalllist.R
import dev.ogabek.recyclerview_8_recyclerviewashorizontalllist.adapter.MainAdapter
import dev.ogabek.recyclerview_8_recyclerviewashorizontalllist.model.Ads

class MainActivity : AppCompatActivity() {
    private lateinit var context: MainActivity
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.rv_main_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerView.isNestedScrollingEnabled = false
    }

    private fun refreshAdapter(members: List<Ads>) {
        adapter = MainAdapter(context, members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Ads> {
        val members = ArrayList<Ads>()
        for (i in 0..50) {
            members.add(Ads())
        }
        return members
    }
}