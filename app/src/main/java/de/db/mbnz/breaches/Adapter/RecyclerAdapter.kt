package de.db.mbnz.breaches.Adapter


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.R
import android.widget.TextView
import android.view.LayoutInflater



/**
 * Created by mbnz on 08.11.17.
 */

public interface OnItemClickListener {
    fun onItemClick(item: Breach?)
}

class RecyclerAdapter(private val breaches: List<Breach>, private val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.BreachHolder>() {

    init {
    }

    override fun getItemCount() = breaches.size

    override fun onBindViewHolder(holder: BreachHolder, position: Int) {
        val breach = breaches[position]
        holder.bind(breach)
        holder.cardView.setOnClickListener { listener.onItemClick(holder.breach) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreachHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent, false)
        return BreachHolder(cardView, listener)
    }

    class BreachHolder(var cardView: View, private val onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(cardView) {
        private var nameLabel = cardView.findViewById<TextView>(R.id.nameTextView)
        private var domainLabel = cardView.findViewById<TextView>(R.id.domainTextView)
        private var breachDateLabel = cardView.findViewById<TextView>(R.id.breachDateTextView)
        var breach: Breach? = null

        init {
        }

        fun bind(breach: Breach) {
            this.breach = breach
            domainLabel.text = """🌍: ${breach.Domain}"""
            nameLabel.text = """📮: ${breach.Name}"""
            breachDateLabel.text = """📅: ${breach.BreachDate}"""
        }
    }
}