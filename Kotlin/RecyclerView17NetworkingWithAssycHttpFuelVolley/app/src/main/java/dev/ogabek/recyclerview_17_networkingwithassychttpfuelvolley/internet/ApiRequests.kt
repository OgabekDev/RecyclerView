package dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.internet

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.RequestParams
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.activity.MainActivity
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.model.Player
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.model.PlayerDates

class ApiRequests(val progressBar: ProgressBar, val mainActivity: MainActivity): ServerUrl {

    fun apiAsyncHttp() {
        progressBar.visibility = View.VISIBLE
        val params = RequestParams()
        val client = AsyncHttpClient()

        client[SERVER_URL, params, object : TextHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseString: String,
                throwable: Throwable
            ) {
                Log.d("Connection Server", "Connection Server Status : $statusCode")
                progressBar.visibility = View.VISIBLE
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseString: String
            ) {
                Log.d("Connection Server", "Connection Response String : $responseString")
                Log.d("Connection Server", "Connection Server Status : $statusCode")
                val playerDates: PlayerDates =
                    Gson().fromJson(responseString, PlayerDates::class.java)
                pogressWithRespond(playerDates)
            }
        }]
    }

    public fun pogressWithRespond(playerDates: PlayerDates) {
        progressBar.visibility = View.GONE
        val message: String = playerDates.message
        Log.d("Connection Server", "Connection Server Dates : $playerDates")
        val players: List<Player> = playerDates.data
        mainActivity.refleshAdapter(players)
    }

}