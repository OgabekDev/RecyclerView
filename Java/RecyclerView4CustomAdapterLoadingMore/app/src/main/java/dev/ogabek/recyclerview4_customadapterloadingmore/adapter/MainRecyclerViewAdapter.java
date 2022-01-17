package dev.ogabek.recyclerview4_customadapterloadingmore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerview4_customadapterloadingmore.R;
import dev.ogabek.recyclerview4_customadapterloadingmore.listener.OnBottomReachedListener;
import dev.ogabek.recyclerview4_customadapterloadingmore.model.Car;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Car> cars;

    public MainRecyclerViewAdapter(Context context, List<Car> cars) {
        this.context = context;
        this.cars = cars;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCars(List<Car> cars) {
        this.cars.addAll(cars);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Car car = cars.get(position);
        if (holder instanceof CustomViewHolder) {
            ((CustomViewHolder) holder).carImage.setImageResource(car.getCarPhoto());
            ((CustomViewHolder) holder).carName.setText(car.getCarName());
            ((CustomViewHolder) holder).carPrice.setText(String.valueOf(car.getPrice()));
        }

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView carImage;
        TextView carName;
        TextView carPrice;

        public CustomViewHolder(View view) {
            super(view);

            carImage = view.findViewById(R.id.iv_carImage);
            carName = view.findViewById(R.id.tv_carName);
            carPrice = view.findViewById(R.id.tv_carPrice);

        }
    }
}
