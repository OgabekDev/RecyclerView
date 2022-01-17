package dev.ogabek.recyclerview8_recyclerviewashorizontalllist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview8_recyclerviewashorizontalllist.R;
import dev.ogabek.recyclerview8_recyclerviewashorizontalllist.model.Member;



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
        return new CustomItemHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomItemHoler) {
            ((CustomItemHoler) holder).itemID.setText(String.valueOf(member.getId()));
            ((CustomItemHoler) holder).itemName.setText(member.getName());
            ((CustomItemHoler) holder).itemSurname.setText(member.getSurname());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private static class CustomItemHoler extends RecyclerView.ViewHolder {

        View view;
        TextView itemID, itemName, itemSurname;

        public CustomItemHoler(View view) {
            super(view);
            this.view = view;

            this.itemID = view.findViewById(R.id.tv_item_id);
            this.itemName = view.findViewById(R.id.tv_item_name);
            this.itemSurname = view.findViewById(R.id.tv_item_surname);

        }
    }
}
