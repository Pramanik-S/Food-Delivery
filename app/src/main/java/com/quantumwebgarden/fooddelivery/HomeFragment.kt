package com.quantumwebgarden.fooddelivery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.quantumwebgarden.fooddelivery.databinding.HomeLayoutBinding


class HomeFragment : Fragment(R.layout.home_layout) {
    private lateinit var adapter: FoodAdapter
    private lateinit var binding: HomeLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val options = FirebaseRecyclerOptions.Builder<Food>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("foods"),Food::class.java)
            .setLifecycleOwner(this)
            .build()
        adapter = FoodAdapter(options)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = HomeLayoutBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

}