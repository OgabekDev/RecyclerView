package dev.ogabek.recyclerview4_customadapterwithloadmore.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview4_customadapterwithloadmore.R
import dev.ogabek.recyclerview4_customadapterwithloadmore.activity.MainActivity
import dev.ogabek.recyclerview4_customadapterwithloadmore.model.Member

class MainAdapter(val context: Context, private var members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_SIMPLE_VIEW = 0
    private val TYPE_ADS_VIEW = 1

    override fun getItemViewType(position: Int): Int {
        return if (isAdsView(position)) {
            TYPE_ADS_VIEW
        } else {
            TYPE_SIMPLE_VIEW
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun updateMemberList(members: List<Member>) {
        this.members = this.members + members
        notifyDataSetChanged()
    }

    private fun isAdsView(position: Int): Boolean = position != 0 && position % 13 == 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ADS_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads_view_layout, parent, false)
            ItemAdsViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
            ItemViewHolder(view)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemPhoto = view.findViewById<ImageView>(R.id.iv_item_photo)
        val itemName = view.findViewById<TextView>(R.id.tv_item_name)
        val itemJobTitle = view.findViewById<TextView>(R.id.tv_item_job_title)
    }

    class ItemAdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]
        if (holder is ItemAdsViewHolder) return
        if (holder is ItemViewHolder) return
    }

    override fun getItemCount(): Int {
        return members.size
    }

}