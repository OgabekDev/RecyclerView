package dev.ogabek.recyclerview3_customadapterwithheaderandfooter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview3_customadapterwithheaderandfooter.R
import dev.ogabek.recyclerview3_customadapterwithheaderandfooter.model.Member

class MainAdapter(val context: Context,val  members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER_VIEW = 0
    private val TYPE_FOOTER_VIEW = 1
    private val TYPE_SIMPLE_VIEW = 2
    private val TYPE_ADS_VIEW = 3

    override fun getItemViewType(position: Int): Int {
        return when {
            isHeader(position) -> {
                TYPE_HEADER_VIEW
            }
            isFooter(position) -> {
                TYPE_FOOTER_VIEW
            }
            isAdsView(position) -> {
                TYPE_ADS_VIEW
            }
            else -> {
                TYPE_SIMPLE_VIEW
            }
        }
    }

    private fun isAdsView(position: Int): Boolean = position != 0 && position % 13 == 0

    private fun isFooter(position: Int): Boolean = position == members.size - 1

    private fun isHeader(position: Int): Boolean = position == 0 

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER_VIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_header_layout, parent, false)
                ItemHeaderViewHolder(view)
            }
            TYPE_SIMPLE_VIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
                ItemViewHolder(view)
            }
            TYPE_ADS_VIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads_layout, parent, false)
                ItemAdsViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_footer_layout, parent, false)
                ItemFooterViewHolder(view)
            }
        }
    }

    class ItemFooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class ItemAdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class ItemHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return members.size
    }

}