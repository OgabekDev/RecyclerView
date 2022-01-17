package dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.R;
import dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.model.Member;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_HEADER = 0;
    private static final int TYPE_ITEM_SIMPLE = 1;
    private static final int TYPE_ITEM_FOOTER = 2;

    Context context;
    List<Member> members;

    public MainRecyclerViewAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_ITEM_HEADER;
        if (isFooter(position)) return TYPE_ITEM_FOOTER;
        return TYPE_ITEM_SIMPLE;
    }

    boolean isHeader(int position) {
        return position == 0;
    }

    boolean isFooter(int position) {
        return position == members.size() - 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_header_view, parent, false);
            return new MainRecyclerViewHeader(view);
        }
        if (viewType == TYPE_ITEM_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_footer_view, parent, false);
            return new MainRecyclerViewFooter(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_view, parent, false);
        return new MainRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (isHeader(position) == isFooter(position)) return;
        Member member = members.get(position);
        if (holder instanceof MainRecyclerView) {
            ((MainRecyclerView) holder).fullName.setText(member.getFirstName() + " " + member.getLastName());
            ((MainRecyclerView) holder).telephoneNumber.setText(member.getTelephoneNumber());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private static class MainRecyclerViewHeader extends RecyclerView.ViewHolder {
        public MainRecyclerViewHeader(View view) {
            super(view);
        }
    }

    private static class MainRecyclerViewFooter extends RecyclerView.ViewHolder {
        public MainRecyclerViewFooter(View view) {
            super(view);
        }
    }

    private static class MainRecyclerView extends RecyclerView.ViewHolder {

        TextView fullName;
        TextView telephoneNumber;

        public MainRecyclerView(View view) {
            super(view);
            fullName = view.findViewById(R.id.tv_fullName);
            telephoneNumber = view.findViewById(R.id.tv_telephoneNumber);
        }
    }
}
