package dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.R
import dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.activity.MainActivity
import dev.ogabek.recyclerview_6_recyclerviewinsidenestedscrollview.model.Member

class MainAdapter(val context: MainActivity, val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return members.size
    }
}