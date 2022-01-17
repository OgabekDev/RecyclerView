package dev.ogabek.recyclerview11_baseclassforactivityadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview11_baseclassforactivityadapter.R;
import dev.ogabek.recyclerview11_baseclassforactivityadapter.model.Member;

public class MainRecyclerViewAdapter extends BaseAdapter {

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
        Member member = members.get(position);

        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).itemName.setText(member.getName() + " " + member.getSurname());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;

        TextView itemName;

        public ItemViewHolder(View view) {
            super(view);
            this.view = view;

            itemName = view.findViewById(R.id.tv_item_name);
        }
    }
}
