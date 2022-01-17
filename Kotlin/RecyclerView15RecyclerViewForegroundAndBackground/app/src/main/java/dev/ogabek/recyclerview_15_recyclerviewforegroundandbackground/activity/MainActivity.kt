package dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.R
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.adapter.MainAdapter
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.model.Member
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.helper.RecyclerItemTouchHelper
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.listener.RecyclerItemTouchHelperListener

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

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        val simpleCalBack = RecyclerItemTouchHelper(0, androidx.recyclerview.widget.ItemTouchHelper.LEFT, object : RecyclerItemTouchHelperListener{
            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder?,
                direction: Int,
                position: Int
            ) {

            }
        })

        ItemTouchHelper(simpleCalBack).attachToRecyclerView(recyclerView)

    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..15) members.add(Member())
        return members
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = MainAdapter(context, members as ArrayList<Member>)
        recyclerView.adapter = adapter
    }

}