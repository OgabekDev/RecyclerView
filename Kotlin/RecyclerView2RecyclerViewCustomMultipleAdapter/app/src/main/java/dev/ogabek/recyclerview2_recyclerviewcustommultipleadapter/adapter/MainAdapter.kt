package dev.ogabek.recyclerview2_recyclerviewcustommultipleadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview2_recyclerviewcustommultipleadapter.R
import dev.ogabek.recyclerview2_recyclerviewcustommultipleadapter.model.Member

class MainAdapter(val context: Context, val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_SIMPLE_VIEW = 0;
    private val TYPE_ADS_VIEW = 1;

    override fun getItemViewType(position: Int): Int {
        return if (position != 0 && position % 13 == 0) TYPE_ADS_VIEW else TYPE_SIMPLE_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ADS_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads_layout, parent, false)
            return ItemAdsHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
            return ItemViewHolder(view)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemPhoto = view.findViewById<ImageView>(R.id.iv_item_photo)
        val itemName = view.findViewById<TextView>(R.id.tv_item_name)
        val itemJobTitle = view.findViewById<TextView>(R.id.tv_item_job_title)
    }

    class ItemAdsHolder(view: View) : RecyclerView.ViewHolder(view) {

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

        if (holder is ItemAdsHolder) {

        }

    }

    override fun getItemCount(): Int {
        return members.size
    }
}