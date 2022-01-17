package dev.ogabek.recyclerview_11_baseclassforactivityandadapter.activity

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.R
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.adapter.MainAdapter
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.model.Member

class MainActivity : BaseActivity() {

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
        val adapter = MainAdapter(this, members)
        recyclerView.adapter = adapter
    }

}