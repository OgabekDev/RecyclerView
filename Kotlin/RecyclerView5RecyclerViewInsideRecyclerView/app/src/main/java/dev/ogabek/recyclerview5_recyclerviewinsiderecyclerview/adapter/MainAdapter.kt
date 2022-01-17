package dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.R
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.Ads
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.Member

class MainAdapter(private val context: Context, private val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_SIMPLE_VIEW = 0;
    private val TYPE_ADS_VIEW = 1;

    override fun getItemViewType(position: Int): Int {
        return if (isAdsView(position)) TYPE_ADS_VIEW else TYPE_SIMPLE_VIEW
    }

    private fun isAdsView(position: Int): Boolean = position != 0 && position % 7 == 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ADS_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads_view_layout, parent, false)
            return ItemAdsViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
            return ItemViewHolder(view)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class ItemAdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_item_recycler_view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemAdsViewHolder) {
            val recyclerView = holder.recyclerView

            recyclerView.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)

            refreshAdsAdapter(recyclerView, prepareAdsList())

        }
    }

    private fun prepareAdsList(): List<Ads> {
        val adsList = ArrayList<Ads>()
        for (i in 0..4) adsList.add(Ads())
        return adsList
    }

    private fun refreshAdsAdapter(recyclerView: RecyclerView, adsList: List<Ads>) {
        val adapter = AdsAdapter(context, adsList)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return members.size
    }

}