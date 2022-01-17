package dev.ogabek.recyclerview1_custombasicadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview1_custombasicadapter.R;
import dev.ogabek.recyclerview1_custombasicadapter.modul.Member;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Member> members;

    public MainRecyclerViewAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_recycler_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public ImageView profilePhoto;
        public TextView fullName;
        public TextView telephoneNumber;

        public CustomViewHolder(View view) {
            super(view);
            this.view = view;

            profilePhoto = view.findViewById(R.id.iv_profilePhoto);
            fullName = view.findViewById(R.id.tv_fullName);
            telephoneNumber = view.findViewById(R.id.tv_telephoneNumber);

        }
    }
}
