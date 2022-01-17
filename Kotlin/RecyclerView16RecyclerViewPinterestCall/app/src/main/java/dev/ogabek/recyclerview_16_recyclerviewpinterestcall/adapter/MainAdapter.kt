package dev.ogabek.recyclerview_16_recyclerviewpinterestcall.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_16_recyclerviewpinterestcall.R
import dev.ogabek.recyclerview_16_recyclerviewpinterestcall.model.Member

class MainAdapter(private val context: Context, private val members: ArrayList<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemPhoto = view.findViewById<ImageView>(R.id.iv_item_image)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.apply {
                when {
                    position % 11 == 0 -> {
                        itemPhoto.setImageResource(R.drawable.img1)
                    }
                    position % 7 == 0 -> {
                        itemPhoto.setImageResource(R.drawable.img2)
                    }
                    position % 5 == 0 -> {
                        itemPhoto.setImageResource(R.drawable.img3)
                    }
                    position % 3 == 0 -> {
                        itemPhoto.setImageResource(R.drawable.img4)
                    }
                    else -> {
                        itemPhoto.setImageResource(R.drawable.img2)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }
}