package dev.ogabek.recyclerview7_recyclerviewasgridview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview7_recyclerviewasgridview.R;
import dev.ogabek.recyclerview7_recyclerviewasgridview.adapter.RecyclerGridViewAdapter;
import dev.ogabek.recyclerview7_recyclerviewasgridview.model.GridViewElement;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        refreshRecyclerViewAdapter(prepareMembersList());

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
    }

    private void refreshRecyclerViewAdapter(List<GridViewElement> elements) {
        RecyclerGridViewAdapter adapter = new RecyclerGridViewAdapter(context, elements);
        recyclerView.setAdapter(adapter);
    }

    private List<GridViewElement> prepareMembersList() {
        List<GridViewElement> elements = new ArrayList<>();
        for (int i = 0; i < 47; i++) {
            elements.add(new GridViewElement(i + "Ogabek", "Matyakubov"));
        }
        return elements;
    }

}