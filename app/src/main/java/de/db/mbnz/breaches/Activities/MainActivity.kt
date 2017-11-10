package de.db.mbnz.breaches.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.Network.AsyncTaskCallback
import de.db.mbnz.breaches.Network.GetBreachesTask
import de.db.mbnz.breaches.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AsyncTaskCallback {

    private lateinit var llm: LinearLayoutManager

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
            llm = LinearLayoutManager(this)
            recyclerView.layoutManager = llm
            recyclerView.adapter = RecyclerAdapter(breaches = it)
        }) ?: return
    }
}
