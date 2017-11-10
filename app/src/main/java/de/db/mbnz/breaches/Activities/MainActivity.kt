package de.db.mbnz.breaches.Activities

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.Network.AsyncTaskCallback
import de.db.mbnz.breaches.Network.GetBreachesTask
import de.db.mbnz.breaches.Network.NetworkClient
import de.db.mbnz.breaches.R
import de.db.mbnz.breaches.R.id.recyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type

class MainActivity : AppCompatActivity(), AsyncTaskCallback {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestBreaches()
    }

    private fun requestBreaches() {
        val asyncBreachesTask = GetBreachesTask()
        asyncBreachesTask.delegate = this
        asyncBreachesTask.execute()
    }

    override fun onSuccess(output: List<Breach>?) {
        val breaches = output?.let({
            linearLayoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.adapter = RecyclerAdapter(breaches = it)
        }) ?: return
    }
}
