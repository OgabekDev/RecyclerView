package dev.ogabek.recyclerview11_baseclassforactivityadapter.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.ogabek.recyclerview11_baseclassforactivityadapter.network.BaseServer;

public class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements BaseServer {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
