package de.db.mbnz.breaches.Views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import de.db.mbnz.breaches.Adapter.OnItemClickListener
import de.db.mbnz.breaches.R
import de.db.mbnz.breaches.ViewModels.BreachHolderViewModel

/**
 * Created by mbnz on 12.11.17.
 */

class BreachHolder(var cardView: View,
                   private val onItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(cardView) {
    private var nameLabel = cardView.findViewById<TextView>(R.id.nameTextView)
    private var domainLabel = cardView.findViewById<TextView>(R.id.domainTextView)
    private var breachDateLabel = cardView.findViewById<TextView>(R.id.breachDateTextView)
    private lateinit var viewModel: BreachHolderViewModel

    init {
    }

    fun bind(viewModel: BreachHolderViewModel) {
        this.viewModel = viewModel
        domainLabel.text = """🌏: ${viewModel.domain}"""
        nameLabel.text = """📮: ${viewModel.name}"""
        breachDateLabel.text = """📅: ${viewModel.breachDate.toString()}"""
    }
}