package dev.ogabek.recyclerview2_createmultitypeadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview2_createmultitypeadapter.R;
import dev.ogabek.recyclerview2_createmultitypeadapter.adapter.CustomAdapter;
import dev.ogabek.recyclerview2_createmultitypeadapter.modul.Member;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = preperMembers();
        refleshAdapter(members);

    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    void refleshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> preperMembers() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            if (i % 5 == 0) {
                members.add(new Member("Ogabek", "Matyakubov", "+998 93 203 73 13", false));
            } else {
                members.add(new Member("Ogabek", "Matyakubov", "+998 99 749 25 81", true));
            }
        }

        return members;
    }

}