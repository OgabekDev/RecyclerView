package dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.R;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.Member;
import dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model.MemberSub;

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

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private List<Member> prepareMembers() {
        List<Member> members = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            if (i % 4 == 0) {
                members.add(new Member("Ogabek Matyakubov", "+998 99 749 25 81", prepareSubMembers()));
            } else {
                members.add(new Member("Ogabek Matyakubov", "+998 99 749 25 81", null));
            }
        }
        return members;
    }

    private List<MemberSub> prepareSubMembers() {
        List<MemberSub> memberSubs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            memberSubs.add(new MemberSub());
        }
        return memberSubs;
    }

}