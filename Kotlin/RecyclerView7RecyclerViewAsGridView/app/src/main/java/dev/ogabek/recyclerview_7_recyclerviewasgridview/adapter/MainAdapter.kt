package dev.ogabek.recyclerview_7_recyclerviewasgridview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_7_recyclerviewasgridview.R
import dev.ogabek.recyclerview_7_recyclerviewasgridview.model.Ads

class MainAdapter(val context: Context, val ads: List<Ads>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads_view_layout, parent, false)
        return ItemAdsViewHolder(view)
    }

    class ItemAdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return ads.size
    }

}