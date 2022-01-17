package dev.ogabek.recyclerview13_recyclerviewwithanimation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview13_recyclerviewwithanimation.R;
import dev.ogabek.recyclerview13_recyclerviewwithanimation.model.Member;


public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Member> members;

    public MainRecyclerViewAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView username;
        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
            username = view.findViewById(R.id.tv_name);
        }
    }
}
