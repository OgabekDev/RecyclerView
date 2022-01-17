package dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.util.List;

import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.R;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.model.Player;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Player> players;

    public MainAdapter(Context context, List<Player> players) {
        this.context = context;
        this.players = players;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Player player = players.get(position);

        if (holder instanceof ItemViewHolder) {
            ImageView imageView = ((ItemViewHolder) holder).itemPhoto;

            Glide.with(context).load(player.getImageURL()).error(R.drawable.ic_launcher_foreground).into(imageView);

            ((ItemViewHolder) holder).itemName.setText(player.getName());
            ((ItemViewHolder) holder).itemDescription.setText(player.getCountry() + ", " + player.getCity());
        }

    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        View view;
        ImageView itemPhoto;
        TextView itemName, itemDescription;

        public ItemViewHolder(View view) {
            super(view);
            this.view = view;

            itemPhoto = view.findViewById(R.id.iv_item_picture);
            itemName = view.findViewById(R.id.tv_item_name);
            itemDescription = view.findViewById(R.id.tv_item_description);

        }
    }
}
