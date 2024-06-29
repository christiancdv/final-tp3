package com.example.parcial.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.data.model.ChipItem
import com.example.parcial.R

class ChipsAdapter(private val chips: List<ChipItem>) :
    RecyclerView.Adapter<ChipsAdapter.ChipViewHolder>() {

    inner class ChipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.name)
        val imagenView: ImageView = itemView.findViewById(R.id.imagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chip_item, parent, false)
        return ChipViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) {
        val chip = chips[position]
        holder.nombreTextView.text = chip.nombre
        holder.imagenView.setImageResource(chip.imagen)
    }

    override fun getItemCount(): Int {
        return chips.size
    }
}