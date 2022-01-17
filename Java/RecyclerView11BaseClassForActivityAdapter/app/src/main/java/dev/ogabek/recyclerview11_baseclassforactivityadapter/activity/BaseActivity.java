package dev.ogabek.recyclerview11_baseclassforactivityadapter.activity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerview11_baseclassforactivityadapter.model.Member;
import dev.ogabek.recyclerview11_baseclassforactivityadapter.network.BaseServer;

public class BaseActivity extends AppCompatActivity implements BaseServer {

    protected String getServer() {
        if (isTester) {
            return SERVER_DEVELOPMENT;
        } else {
            return SERVER_DEPLOYMENT;
        }
    }

    protected List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            members.add(new Member("Ogabek", "Matyakubov"));
        }
        return members;
    }

}
