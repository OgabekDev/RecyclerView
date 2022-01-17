package dev.ogabek.recyclerview14_recyclerviewdragandswap.helper;

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);

}
