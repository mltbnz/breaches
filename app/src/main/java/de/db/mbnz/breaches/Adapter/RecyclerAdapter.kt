package de.db.mbnz.breaches.Adapter


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.R
import android.widget.TextView
import android.view.LayoutInflater
import de.db.mbnz.breaches.ViewModels.BreachHolderViewModel
import de.db.mbnz.breaches.Views.BreachHolder


/**
 * Created by mbnz on 08.11.17.
 */

public interface OnItemClickListener {
    fun onItemClick(item: Breach?)
}

class RecyclerAdapter(private val breaches: List<Breach>, private val listener: OnItemClickListener) : RecyclerView.Adapter<BreachHolder>() {

    override fun getItemCount() = breaches.size

    override fun onBindViewHolder(holder: BreachHolder, position: Int) {
        val breachViewModel = BreachHolderViewModel(breaches[position])
        holder.bind(breachViewModel)
        holder.cardView.setOnClickListener { listener.onItemClick(breachViewModel.breach) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreachHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent, false)
        return BreachHolder(cardView, listener)
    }
}