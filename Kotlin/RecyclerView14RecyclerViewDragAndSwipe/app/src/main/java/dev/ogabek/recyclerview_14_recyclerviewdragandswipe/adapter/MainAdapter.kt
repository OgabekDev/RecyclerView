package dev.ogabek.recyclerview_14_recyclerviewdragandswipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.R
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.helper.ItemTouchHelperAdapter
import dev.ogabek.recyclerview_14_recyclerviewdragandswipe.model.Member
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter(val context: Context, private val members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id = view.findViewById<TextView>(R.id.tv_item_job_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.apply {
                id.text = members[position].count
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(members, i, i + 1)
            }
        } else {
            for (i in toPosition until fromPosition) {
                if (toPosition != 0) {
                    Collections.swap(members, i, i - 1)
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        members.removeAt(position)
        notifyItemRemoved(position)
    }
}
