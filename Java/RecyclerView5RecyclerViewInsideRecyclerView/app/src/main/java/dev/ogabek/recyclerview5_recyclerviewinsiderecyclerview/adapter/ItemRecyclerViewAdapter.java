package dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.R;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.Member;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.MemberSub;


public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MemberSub> memberSubs;

    public ItemRecyclerViewAdapter(Context context, List<MemberSub> memberSubs) {
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_list_item, parent, false);
        return new ItemHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolderItem) {
            ((ItemHolderItem) holder).itemTitle.setText(memberSubs.get(position).getStatus());
            ((ItemHolderItem) holder).itemDescription.setText("Offline");
        }
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }

    private static class ItemHolderItem extends RecyclerView.ViewHolder {
        View view;
        TextView itemTitle, itemDescription;
        public ItemHolderItem(View view) {
            super(view);
            this.view = view;

            itemTitle = this.view.findViewById(R.id.tv_sub_title);
            itemDescription = this.view.findViewById(R.id.tv_sub_description);
        }
    }
}
