package dev.ogabek.recyclerview8_recyclerviewashorizontalllist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview8_recyclerviewashorizontalllist.R;
import dev.ogabek.recyclerview8_recyclerviewashorizontalllist.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview8_recyclerviewashorizontalllist.model.Member;

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

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false ));
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            members.add(new Member(i, "Ogabek", "Matyakubov"));
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

}