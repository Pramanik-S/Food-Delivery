package com.quantumwebgarden.fooddelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.quantumwebgarden.fooddelivery.databinding.FoodItemBinding


class FoodAdapter(option: FirebaseRecyclerOptions<Food>) :
    FirebaseRecyclerAdapter<Food, FoodAdapter.ViewHolder>(option) {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = FoodItemBinding.bind(itemView)
        val nameTextView: TextView = binding.nameTextView
        val categoryTextView: TextView = binding.categoryTextView
        val priceTextView: TextView = binding.priceTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Food) {
        holder.nameTextView.text = model.name
        holder.categoryTextView.text = model.cat
        holder.priceTextView.text = model.desc
    }
}


