package dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.R;
import dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.adapter.MainScrollViewAdapter;
import dev.ogabek.recyclerview6_recyclerviewinsidenedtedscrollview.model.Member;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        refreshAdapter(prepareMemberList());

    }

    private void refreshAdapter(List<Member> members) {
        MainScrollViewAdapter adapter = new MainScrollViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private void initViews() {
        nestedScrollView = findViewById(R.id.ncv_mainNestedScrollView);
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            members.add(new Member("Ogabek Matyakubov -> @OgabekDev", "+998 99 749 25 81"));
        }
        return members;
    }

}