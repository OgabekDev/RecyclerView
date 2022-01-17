package dev.ogabek.recyclerview_11_baseclassforactivityandadapter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.network.BaseServer

open class BaseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(), BaseServer {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}