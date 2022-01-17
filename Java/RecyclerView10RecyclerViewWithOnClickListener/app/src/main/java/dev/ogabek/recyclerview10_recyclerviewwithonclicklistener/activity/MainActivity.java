package dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.R;
import dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview10_recyclerviewwithonclicklistener.model.Member;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        refreshAdapter(prepareMembersList());

    }

    private List<Member> prepareMembersList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            members.add(new Member(i + 1, "Ogabek Matyakubov", "+998 99 749 25 81"));
        }
        return members;
    }

    private void initView() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(this, members);
        recyclerView.setAdapter(adapter);
    }

    public void ShowDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

}