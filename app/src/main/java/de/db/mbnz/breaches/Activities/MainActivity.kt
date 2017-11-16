package de.db.mbnz.breaches.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import de.db.mbnz.breaches.Adapter.OnItemClickListener
import de.db.mbnz.breaches.Adapter.RecyclerAdapter
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.Network.AsyncTaskCallback
import de.db.mbnz.breaches.Network.GetBreachesTask
import de.db.mbnz.breaches.R
import de.db.mbnz.breaches.ViewModels.DetailViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AsyncTaskCallback {

    private lateinit var llm: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestBreaches()
    }

    private fun requestBreaches() {
        progressBar.visibility = View.VISIBLE
        val asyncBreachesTask = GetBreachesTask()
        asyncBreachesTask.delegate = this
        asyncBreachesTask.execute()
    }

    interface CustomItemClickListener {
        fun onItemClick(v: View, position: Int)
    }

    private fun showDetailActivity(item: Breach?) {
        item?.let {
            val viewModel = DetailViewModel(it)
            val intent = BreachDetailActivity.newIntent(this, viewModel)
            startActivity(intent)
        }
    }

    // OnItemClickListener
    override fun onSuccess(output: List<Breach>?) {
        progressBar.visibility = View.INVISIBLE
        val breaches = output?.let({
            llm = LinearLayoutManager(this)
            recyclerView.layoutManager = llm
            val listener = object : OnItemClickListener {
                override fun onItemClick(item: Breach?) {
                    showDetailActivity(item)
                }
            }
            val sortedList = it.sortedWith(compareByDescending { it.BreachDate })
            recyclerView.adapter = RecyclerAdapter(sortedList, listener)
        }) ?: return
    }
}
