package dev.ogabek.recyclerview1_custombasicadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview1_custombasicadapter.R;
import dev.ogabek.recyclerview1_custombasicadapter.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview1_custombasicadapter.modul.Member;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = preperMemberList();
        refleshAdapter(members);

    }

    void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    void refleshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> preperMemberList() {
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(new Member(R.drawable.ic_person, "Ogabek Matyakubov", "+998 99 749 25 81"));
        }

        return list;
    }

}