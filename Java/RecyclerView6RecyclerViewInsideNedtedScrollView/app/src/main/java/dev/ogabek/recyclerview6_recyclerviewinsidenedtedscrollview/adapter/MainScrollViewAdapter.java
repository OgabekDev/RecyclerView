package dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.R;
import dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.model.Member;

public class MainScrollViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Member> members;

    public MainScrollViewAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new SimpleItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class SimpleItemHolder extends RecyclerView.ViewHolder {
        View view;
        public SimpleItemHolder(View view) {
            super(view);
            this.view = view;
        }
    }
}
