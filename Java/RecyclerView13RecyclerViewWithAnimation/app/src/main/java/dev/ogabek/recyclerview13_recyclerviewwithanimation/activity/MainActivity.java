package dev.ogabek.recyclerview13_recyclerviewwithanimation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview13_recyclerviewwithanimation.R;
import dev.ogabek.recyclerview13_recyclerviewwithanimation.adapter.MainRecyclerViewAdapter;
import dev.ogabek.recyclerview13_recyclerviewwithanimation.model.Member;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        refreshAdapter(prepareMemberList());

        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String networkOperator = tm.getNetworkOperatorName();
        if("Android".equals(networkOperator)) { //Since Android emulator always retuns "Android" as network operator, I use above code
            // Emulator
            Log.d("@@"," in Emulator");
            finish();
        }
        else {
            // Device
            Log.d("@@","in Device");
        }

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
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(animation);

    }

    private void refreshAdapter(List<Member> members) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

}