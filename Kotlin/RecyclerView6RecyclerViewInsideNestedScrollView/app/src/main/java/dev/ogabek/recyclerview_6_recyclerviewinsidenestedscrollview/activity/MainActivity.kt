package dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.R
import dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.adapter.MainAdapter
import dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.model.Member

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
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        recyclerView.isNestedScrollingEnabled = false
    }

    private fun refreshAdapter(members: List<Member>) {
        adapter = MainAdapter(context, members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..50) {
            members.add(Member(R.drawable.img_user, "Ogabek Matyakubov", "Mobile Developer"))
        }
        return members
    }
}