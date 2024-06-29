package com.example.parcial.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.data.model.ChipItem
import com.example.parcial.R
import com.example.parcial.data.model.Food

class FoodAdapter(private val foods: List<Food>, var onClick: (Food) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.name_food)
        val descripcionTextView: TextView = itemView.findViewById(R.id.description_food)
        val puntuacionTextView: TextView = itemView.findViewById(R.id.puntacion_food)
        val imagenView: ImageView = itemView.findViewById(R.id.imagen_food)

        fun getCard(): CardView {
            return itemView.findViewById(R.id.card_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_card, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.nombreTextView.text = food.nombre
        holder.puntuacionTextView.text = food.puntuacion
        holder.descripcionTextView.text = food.descripcion
        holder.imagenView.setImageResource(food.imagen)

        //Se le settea un click listener a las cards
        holder.getCard().setOnClickListener() {
            onClick(foods[position])
        }
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}