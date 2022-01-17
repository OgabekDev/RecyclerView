package dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.internet;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.activity.MainActivity;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.helper.ServerURL;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.model.Player;
import dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.model.PlayerDates;

public class APIRequests implements ServerURL {

    ProgressBar progressBar;
    MainActivity mainActivity;

    public APIRequests(ProgressBar progressBar, MainActivity mainActivity) {
        this.progressBar = progressBar;
        this.mainActivity = mainActivity;
    }

    public void apiAsyncHttp() {
        progressBar.setVisibility(View.VISIBLE);
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(SERVER_URL, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("Connection Server", "Connection Server Status : " + statusCode);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("Connection Server", "Connection Response String : " + responseString);
                Log.d("Connection Server", "Connection Server Status : " + statusCode);

                PlayerDates playerDates = new Gson().fromJson(responseString, PlayerDates.class);
                pogressWithRespond(playerDates);
            }
        });
    }



    private void pogressWithRespond(final  PlayerDates playerDates) {
        progressBar.setVisibility(View.GONE);
        String message = playerDates.getMessage();
        Log.d("Connection Server", "Connection Server Dates : " + playerDates.toString());
        List<Player> players = playerDates.getPlayers();
        mainActivity.refleshAdapter(players);
    }

}