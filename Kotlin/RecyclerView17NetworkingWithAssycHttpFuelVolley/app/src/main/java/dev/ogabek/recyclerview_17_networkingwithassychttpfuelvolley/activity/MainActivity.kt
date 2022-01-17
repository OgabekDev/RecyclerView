package dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.R
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.adapter.MainAdapter
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.internet.ApiRequests
import dev.ogabek.recyclerview_17_networkingwithassychttpfuelvolley.model.Player

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var apiRequests: ApiRequests

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        apiRequests.apiAsyncHttp()

    }

    fun refleshAdapter(players: List<Player>) {
        val adapter = MainAdapter(context, players as ArrayList<Player>)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        context = this
        progressBar = findViewById(R.id.pb_main_progress_bar)
        apiRequests = ApiRequests(progressBar, this@MainActivity)
        recyclerView = findViewById(R.id.rv_main_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

}