package dev.ogabek.recyclerview_14_recyclerviewdragandswipe.helper

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int)

    fun onItemDismiss(position: Int)

}