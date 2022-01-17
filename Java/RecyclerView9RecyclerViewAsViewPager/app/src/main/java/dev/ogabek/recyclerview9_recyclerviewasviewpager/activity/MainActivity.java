package dev.ogabek.recyclerview9_recyclerviewasviewpager.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview9_recyclerviewasviewpager.R;
import dev.ogabek.recyclerview9_recyclerviewasviewpager.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview9_recyclerviewasviewpager.model.Member;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        refreshAdapter(prepareMemberList());

    }

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            members.add(new Member("Ogabek", i));
        }
        return members;
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int activePosition = 0;
                if (manager != null) {
                    activePosition = manager.findFirstVisibleItemPosition();
                }
                if (activePosition != RecyclerView.NO_POSITION) return;
                Log.d("Active Position", "Active Position: " + activePosition);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

}