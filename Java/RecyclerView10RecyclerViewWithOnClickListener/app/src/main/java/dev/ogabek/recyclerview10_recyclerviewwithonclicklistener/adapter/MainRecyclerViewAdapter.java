package dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.R;
import dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.activity.MainActivity;
import dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.model.Member;


public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainActivity mainActivity;
    List<Member> members;

    public MainRecyclerViewAdapter(MainActivity mainActivity, List<Member> members) {
        this.mainActivity = mainActivity;
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
            ((ItemViewHolder) holder).itemID.setText(member.getId());
            ((ItemViewHolder) holder).itemName.setText(member.getName());
            ((ItemViewHolder) holder).itemNumber.setText(member.getTelephoneNumber());

            CardView cardView = ((ItemViewHolder) holder).cardView;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message = "Item ID :  " + member.getId() + "\n" +
                            "Item Name :  " + member.getName() + "\n" +
                            "Item Number :  " + member.getTelephoneNumber();
                    mainActivity.ShowDialog("You Pressed Item Data", message);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        View view;

        CardView cardView;
        TextView itemID, itemName, itemNumber;

        public ItemViewHolder(View view) {
            super(view);
            this.view = view;

            cardView = view.findViewById(R.id.cv_itemCardView);
            itemID = view.findViewById(R.id.tv_itemID);
            itemName = view.findViewById(R.id.tv_itemName);
            itemNumber = view.findViewById(R.id.tv_itemNumber);

        }
    }
}
