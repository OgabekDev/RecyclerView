package dev.ogabek.recyclerview_9_recyclerviewasviewpager.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import dev.ogabek.recyclerview_9_recyclerviewasviewpager.R
import dev.ogabek.recyclerview_9_recyclerviewasviewpager.adapter.MainAdapter
import dev.ogabek.recyclerview_9_recyclerviewasviewpager.model.Ads
import java.util.ArrayList

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
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val manager = recyclerView.layoutManager as LinearLayoutManager?
                var activePosition = 0
                if (manager != null) {
                    activePosition = manager.findFirstVisibleItemPosition()
                }
                if (activePosition != RecyclerView.NO_POSITION) return
                Log.d("Active Position", "Active Position: $activePosition")
            }
        })
    }

    private fun refreshAdapter(ads: List<Ads>) {
        val adapter = MainAdapter(context, ads)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Ads> {
        val members: MutableList<Ads> = ArrayList<Ads>()
        for (i in 0..50) {
            members.add(Ads())
        }
        return members
    }
}