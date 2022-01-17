package dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.List;

import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.R;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.adapter.MainAdapter;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.internet.APIRequests;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.model.Player;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    APIRequests apiRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        apiRequests.apiAsyncHttp();

    }

    public void refleshAdapter(List<Player> players) {
        MainAdapter adapter = new MainAdapter(context, players);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        context = this;
        progressBar = findViewById(R.id.pb_mainProgressBar);
        apiRequests = new APIRequests(progressBar, MainActivity.this);
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }
}