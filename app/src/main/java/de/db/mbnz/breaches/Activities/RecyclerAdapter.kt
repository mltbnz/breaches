package de.db.mbnz.breaches.Activities


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.db.mbnz.breaches.Models.Breach
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import android.R.layout
import kotlinx.android.synthetic.main.activity_main.view.*
import de.db.mbnz.breaches.R
import android.support.annotation.LayoutRes
import android.util.Log
import de.db.mbnz.breaches.Extensions.inflate
import de.db.mbnz.breaches.Network.AsyncTaskCallback

/**
 * Created by mbnz on 08.11.17.
 */

class RecyclerAdapter(private val breaches: List<Breach>) : RecyclerView.Adapter<RecyclerAdapter.BreachHolder>() {

    override fun getItemCount() = breaches.size

    override fun onBindViewHolder(holder: RecyclerAdapter.BreachHolder, position: Int) {
        val breach = breaches.get(position)
        holder.bind(breach)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.BreachHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return BreachHolder(inflatedView)
    }

    class BreachHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var breach: Breach? = null

        init {
        }

        fun bind(breach: Breach) {
            this.breach = breach
            view.name.text = breach.name
            view.title.text = breach.title
            view.domain.text = breach.domain
            view.breachDate.text = breach.breachDate
        }
    }
}