package dev.ogabek.recyclerview2_createmultitypeadapter.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview2_createmultitypeadapter.R;
import dev.ogabek.recyclerview2_createmultitypeadapter.modul.Member;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_TRUE = 0;
    private static final int TYPE_AVAILABLE_FALSE = 1;
    private static final String TAG = "CustomAdapter";

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (members.get(position).isAvailable()) {
            return TYPE_AVAILABLE_TRUE;
        }
        return TYPE_AVAILABLE_FALSE;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AVAILABLE_TRUE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list_true, parent, false);
            return new CustomViewTrueHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_list_false, parent, false);
        return new CustomViewFalseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof CustomViewTrueHolder) {
            ((CustomViewTrueHolder) holder).profilePhoto.setImageResource(R.drawable.ic_person);
            ((CustomViewTrueHolder) holder).fullName.setText(member.getFirstName() + " " + member.getLastName());
            ((CustomViewTrueHolder) holder).telephoneNumber.setText(member.getTelephoneNumber());
        }
        if (holder instanceof CustomViewFalseHolder) {
            ((CustomViewFalseHolder) holder).profilePhoto.setImageResource(R.drawable.ic_person);
            ((CustomViewFalseHolder) holder).fullName.setText(member.getFirstName() + " " + member.getLastName());
            ((CustomViewFalseHolder) holder).telephoneNumber.setText(member.getTelephoneNumber());
        }
    }

    private static class CustomViewTrueHolder extends RecyclerView.ViewHolder {

        View view;
        ImageView profilePhoto;
        TextView fullName;
        TextView telephoneNumber;

        public CustomViewTrueHolder(View view) {
            super(view);
            this.view = view;

            profilePhoto = view.findViewById(R.id.iv_profilePhotoTrue);
            fullName = view.findViewById(R.id.tv_fullNameTrue);
            telephoneNumber = view.findViewById(R.id.tv_telephoneNumberTrue);

        }

    }

    private static class CustomViewFalseHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView profilePhoto;
        TextView fullName;
        TextView telephoneNumber;

        public CustomViewFalseHolder(View view) {
            super(view);
            this.view = view;
            profilePhoto = view.findViewById(R.id.iv_profilePhotoFalse);
            fullName = view.findViewById(R.id.tv_fullNameFalse);
            telephoneNumber = view.findViewById(R.id.tv_telephoneNumberFalse);

        }

    }
}
