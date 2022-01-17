package dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.R;
import dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview_3_customadapterwithheaderandfooter.model.Member;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMembers();
        refreshAdapter(members);

    }

    private List<Member> prepareMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member());
        for (int i = 0; i < 100; i++) {
            members.add(new Member("Ogabek", "Matyakubov", "+998 99 749 25 81"));
        }
        members.add(new Member());
        return members;
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

}