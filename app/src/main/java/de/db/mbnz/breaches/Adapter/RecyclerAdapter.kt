package de.db.mbnz.breaches.Adapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import de.db.mbnz.breaches.Extensions.inflate
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.R
import android.widget.TextView

/**
 * Created by mbnz on 08.11.17.
 */

class RecyclerAdapter(private val breaches: List<Breach>) : RecyclerView.Adapter<RecyclerAdapter.BreachHolder>() {

    override fun getItemCount() = breaches.size

    override fun onBindViewHolder(holder: BreachHolder, position: Int) {
        val breach = breaches.get(position)
        holder.bind(breach)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreachHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return BreachHolder(inflatedView)
    }

    class BreachHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var nameLabel = v.findViewById<TextView>(R.id.nameTextView)
        private var domainLabel = v.findViewById<TextView>(R.id.domainTextView)
        private var breachDateLabel = v.findViewById<TextView>(R.id.breachDateTextView)
        private var breach: Breach? = null

        init {}

        fun bind(breach: Breach) {
            this.breach = breach
            domainLabel.text = "\uD83C\uDF0D: " + breach.Domain
            nameLabel.text = "\uD83D\uDCEE: "  +  breach.Name
            breachDateLabel.text = "\uD83D\uDCC5: "  + breach.BreachDate
        }
    }
}