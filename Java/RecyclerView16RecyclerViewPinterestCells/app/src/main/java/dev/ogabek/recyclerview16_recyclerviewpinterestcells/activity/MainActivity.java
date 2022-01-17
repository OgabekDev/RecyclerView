package dev.ogabek.recyclerview16_recyclerviewpinterestcells.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview16_recyclerviewpinterestcells.R;
import dev.ogabek.recyclerview16_recyclerviewpinterestcells.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview16_recyclerviewpinterestcells.helper.SpacesItemDecoration;
import dev.ogabek.recyclerview16_recyclerviewpinterestcells.model.Member;

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

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            members.add(new Member());
        }
        return members;
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        recyclerView.addItemDecoration(decoration);

    }

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

}