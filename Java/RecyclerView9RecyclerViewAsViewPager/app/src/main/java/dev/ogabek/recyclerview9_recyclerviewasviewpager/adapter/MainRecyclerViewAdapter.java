package dev.ogabek.recyclerview9_recyclerviewasviewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview9_recyclerviewasviewpager.R;
import dev.ogabek.recyclerview9_recyclerviewasviewpager.model.Member;


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
        return new ViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof ViewItemHolder) {
            ((ViewItemHolder) holder).itemID.setText(member.getId());
            ((ViewItemHolder) holder).itemName.setText(member.getName());
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class ViewItemHolder extends RecyclerView.ViewHolder {

        View view;
        TextView itemID, itemName;

        public ViewItemHolder(View view) {
            super(view);
            this.view = view;

            itemID = view.findViewById(R.id.tv_item_id);
            itemName = view.findViewById(R.id.tv_item_name);

        }
    }
}
