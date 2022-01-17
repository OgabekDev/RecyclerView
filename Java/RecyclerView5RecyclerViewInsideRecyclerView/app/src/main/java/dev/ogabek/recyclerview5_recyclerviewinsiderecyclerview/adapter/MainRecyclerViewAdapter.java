package dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.R;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.Member;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.MemberSub;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    Context context;
    List<Member> members;

    public MainRecyclerViewAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_list, parent, false);
            return new CustomListHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new CustomItemHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);
        if (member.getMemberSubs() == null)
            return TYPE_ITEM_VIEW;
        else
            return TYPE_ITEM_LIST;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView = ((CustomListHolder) holder).listRecyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshSubAdapter(recyclerView, memberSubs);
        }

        if (holder instanceof CustomItemHolder) {

        }
    }

    private void refreshSubAdapter(RecyclerView recyclerView, List<MemberSub> memberSubs) {
        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(context, memberSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private static class CustomListHolder extends RecyclerView.ViewHolder {
        View view;
        RecyclerView listRecyclerView;
        public CustomListHolder(View view) {
            super(view);
            this.view = view;

            listRecyclerView = this.view.findViewById(R.id.rv_listRecyclerView);

        }
    }

    private static class CustomItemHolder extends RecyclerView.ViewHolder {
        View view;
        TextView itemTitle;
        public CustomItemHolder(View view) {
            super(view);
            this.view = view;

            itemTitle = this.view.findViewById(R.id.tv_item_title);

        }
    }
}
