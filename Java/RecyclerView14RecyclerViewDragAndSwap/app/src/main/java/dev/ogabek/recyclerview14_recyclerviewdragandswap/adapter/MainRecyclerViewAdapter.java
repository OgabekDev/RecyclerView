package dev.ogabek.recyclerview14_recyclerviewdragandswap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import dev.ogabek.recyclerview14_recyclerviewdragandswap.R;
import dev.ogabek.recyclerview14_recyclerviewdragandswap.helper.ItemTouchHelperAdapter;
import dev.ogabek.recyclerview14_recyclerviewdragandswap.model.Member;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {
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
            ((ItemViewHolder) holder).itemName.setText(member.getName());
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(members, i, i + 1);
            }
        } else {
            if (toPosition != 0) {
                for (int i = toPosition; i < fromPosition; i++) {
                    Collections.swap(members, i, i - 1);
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        members.remove(position);
        notifyItemRemoved(position);
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView itemName;
        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
            itemName = view.findViewById(R.id.tv_itemName);
        }
    }
}
