package dev.ogabek.recyclerview16_recyclerviewpinterestcells.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview16_recyclerviewpinterestcells.R;
import dev.ogabek.recyclerview16_recyclerviewpinterestcells.model.Member;


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
        if (holder instanceof ItemViewHolder) {
            if (position % 11 == 0) {
                ((ItemViewHolder) holder).itemPhoto.setImageResource(R.drawable.img1);
            } else if (position % 7 == 0) {
                ((ItemViewHolder) holder).itemPhoto.setImageResource(R.drawable.img2);
            } else if (position % 5 == 0) {
                ((ItemViewHolder) holder).itemPhoto.setImageResource(R.drawable.img3);
            } else if (position % 3 == 0) {
                ((ItemViewHolder) holder).itemPhoto.setImageResource(R.drawable.img4);
            } else {
                ((ItemViewHolder) holder).itemPhoto.setImageResource(R.drawable.img2);
            }
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;

        ImageView itemPhoto;

        public ItemViewHolder(View view) {
            super(view);
            this.view = view;

            itemPhoto = view.findViewById(R.id.iv_item_image);
        }
    }
}
