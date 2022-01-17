package dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.listener;

import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerItemTouchHelperListener {
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
}
