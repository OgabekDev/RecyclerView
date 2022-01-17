package dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.R;
import dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.helper.RecyclerItemTouchHelper;
import dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.listener.RecyclerItemTouchHelperListener;
import dev.ogabek.recyclerview15_recyclerviewforegroundandbackgroundcell.model.Member;

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
            members.add(new Member(String.valueOf(i)));
        }
        return members;
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ItemTouchHelper.SimpleCallback itemHelperCallBack = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, new RecyclerItemTouchHelperListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

            }
        });
        new ItemTouchHelper(itemHelperCallBack).attachToRecyclerView(recyclerView);

    }

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }


}