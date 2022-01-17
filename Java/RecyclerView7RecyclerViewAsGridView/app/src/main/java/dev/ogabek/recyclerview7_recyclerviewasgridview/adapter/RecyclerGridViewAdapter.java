package dev.ogabek.recyclerview7_recyclerviewasgridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview7_recyclerviewasgridview.R;
import dev.ogabek.recyclerview7_recyclerviewasgridview.model.GridViewElement;

public class RecyclerGridViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<GridViewElement> elements;

    public RecyclerGridViewAdapter(Context context, List<GridViewElement> elements) {
        this.context = context;
        this.elements = elements;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_grid_view, parent, false);
        return new ViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridViewElement element = elements.get(position);
        if (holder instanceof ViewItemHolder) {
            ((ViewItemHolder) holder).title.setText(element.getTitle());
            ((ViewItemHolder) holder).description.setText(element.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    private class ViewItemHolder extends RecyclerView.ViewHolder {
        View view;
        TextView title, description;
        public ViewItemHolder(View view) {
            super(view);
            this.view = view;

            this.title = this.view.findViewById(R.id.tv_item_title);
            this.description = this.view.findViewById(R.id.tv_item_description);
        }
    }
}
