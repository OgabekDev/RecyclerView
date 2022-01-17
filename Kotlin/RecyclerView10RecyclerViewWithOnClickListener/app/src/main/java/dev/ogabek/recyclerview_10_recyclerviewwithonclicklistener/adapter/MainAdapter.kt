package dev.ogabek.recyclerview_10_recyclerviewwithonclicklistener.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_10_recyclerviewwithonclicklistener.R
import dev.ogabek.recyclerview_10_recyclerviewwithonclicklistener.activity.MainActivity
import dev.ogabek.recyclerview_10_recyclerviewwithonclicklistener.model.Member

class MainAdapter(val context: MainActivity, val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item = view.findViewById<LinearLayout>(R.id.ll_item)
        val itemName = view.findViewById<TextView>(R.id.tv_item_name)
        val itemJobTitle = view.findViewById<TextView>(R.id.tv_item_job_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is ItemViewHolder) {
            holder.apply {
                itemName.text = member.name
                itemJobTitle.text = member.jobTitle
                item.setOnClickListener {
                    context.showDialogMessage("You Clicked Item", "Name : ${member.name}\nID : ${member.jobTitle}")
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

}