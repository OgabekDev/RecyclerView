package dev.ogabek.recyclerview1_recyclerviewcustombasicadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview1_recyclerviewcustombasicadapter.R
import dev.ogabek.recyclerview1_recyclerviewcustombasicadapter.model.Member

class MainAdapter(val context: Context, private val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is ItemViewHolder) {
            holder.apply {
                itemPhoto.setImageResource(member.photo)
                itemName.text = member.name
                itemJobTitle.text = member.jobTitle
            }
        }

    }

    override fun getItemCount(): Int {
        return members.size
    }


}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val itemPhoto: ImageView = view.findViewById(R.id.iv_item_photo)
    val itemName: TextView = view.findViewById(R.id.tv_item_name)
    val itemJobTitle: TextView = view.findViewById(R.id.tv_item_job_title)

}
