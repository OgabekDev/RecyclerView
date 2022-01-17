package dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.R
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.Ads

class AdsAdapter(val context: Context, val adsList: List<Ads>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads_item_view_layout, parent, false)
        return AdsItemViewHolder(view)
    }

    class AdsItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val adsItemMainImage = view.findViewById<ImageView>(R.id.iv_item_ads_main_icon)
        val adsItemImage = view.findViewById<ImageView>(R.id.iv_item_ads_icon)
        val adsItemMainTitle = view.findViewById<TextView>(R.id.tv_item_ads_main_title)
        val adsItemTitle = view.findViewById<TextView>(R.id.tv_item_ads_title)
        val adsItemText = view.findViewById<TextView>(R.id.tv_item_ads_text)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return adsList.size
    }


}