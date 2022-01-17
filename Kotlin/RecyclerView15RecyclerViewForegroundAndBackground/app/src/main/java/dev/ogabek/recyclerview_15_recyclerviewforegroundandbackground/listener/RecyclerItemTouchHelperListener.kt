package dev.ogabek.recyclerview_15_recyclerviewforegroundandbackground.listener

import androidx.recyclerview.widget.RecyclerView

interface RecyclerItemTouchHelperListener {

    fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int, position: Int)

}