package de.db.mbnz.breaches.Activities


import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import de.db.mbnz.breaches.Extensions.inflate
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.R
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import android.view.LayoutInflater
import android.widget.TextView

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
        private var nameLabel = v.findViewById<TextView>(R.id.nameTextView)
        private var titleLabel = v.findViewById<TextView>(R.id.titleTextView)
        private var domainLabel = v.findViewById<TextView>(R.id.domainTextView)
        private var breachDateLabel = v.findViewById<TextView>(R.id.breachDateTextView)
        private var breach: Breach? = null

        init {}

        fun bind(breach: Breach) {
            this.breach = breach
            nameLabel.text = breach.name
            titleLabel.text = breach.title
            domainLabel.text = breach.domain
            breachDateLabel.text = breach.breachDate
        }
    }
}