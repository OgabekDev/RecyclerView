package dev.ogabek.recyclerview4_customadapterloadingmore.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview4_customadapterloadingmore.R;
import dev.ogabek.recyclerview4_customadapterloadingmore.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview4_customadapterloadingmore.listener.OnBottomReachedListener;
import dev.ogabek.recyclerview4_customadapterloadingmore.model.Car;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    List<Car> cars;
    MainRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        cars = preperCarsList();
        refreshAdapter(cars);

    }

    private void refreshAdapter(List<Car> cars) {
        adapter = new MainRecyclerViewAdapter(context, cars);
        recyclerView.setAdapter(adapter);
    }

    int indexes = 0;

    private List<Car> preperCarsList() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            cars.add(new Car(R.drawable.car, "Lamborghini ", indexes++));
        }
        return cars;
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                GridLayoutManager layoutManager = GridLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    adapter.setCars(preperCarsList());
                    Toast.makeText(context, "You reached the bottom", Toast.LENGTH_SHORT).show();
                    adapter.setCars(preperCarsList());
                }
            }
        });
    }
}