package dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.R
import dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.model.Member

class MainAdapter(val context: Context, val members: ArrayList<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foregroundView = view.findViewById<RelativeLayout>(R.id.rl_view_foreground)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {

        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

}