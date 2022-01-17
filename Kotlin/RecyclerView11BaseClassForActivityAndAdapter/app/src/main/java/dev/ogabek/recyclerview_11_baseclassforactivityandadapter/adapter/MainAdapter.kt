package dev.ogabek.recyclerview_11_baseclassforactivityandadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.R
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.activity.MainActivity
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.model.Member

class MainAdapter(val context: MainActivity, val members: List<Member>): BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_item_name)
        val userName = view.findViewById<TextView>(R.id.tv_item_job_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is ItemViewHolder) {
            holder.apply {
                name.text = member.name
                userName.text = member.userName
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

}