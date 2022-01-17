package dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.R
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.model.Player

class MainAdapter(private val context: Context, private val players: ArrayList<Player>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playerPhoto = view.findViewById<ImageView>(R.id.iv_item_picture)
        val playerName = view.findViewById<TextView>(R.id.tv_item_name)
        val playerPlace = view.findViewById<TextView>(R.id.tv_item_description)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val player = players[position]
        if (holder is ItemViewHolder) {
            holder.apply {
                Glide.with(context).load(player.imgURL).error(R.drawable.ic_launcher_background).into(playerPhoto)
                playerName.text = player.name
                playerPlace.text = "${player.country}, ${player.city}"
            }
        }
    }

    override fun getItemCount(): Int {
        return players.size
    }

}