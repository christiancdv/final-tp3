package com.example.parcial.ui.listado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.databinding.FragmentListadoBinding
import com.example.parcial.adapters.ChipsAdapter
import com.example.parcial.data.model.ChipItem
import com.example.parcial.R
import com.example.parcial.adapters.FoodAdapter
import com.example.parcial.data.model.Food

class ListadoFragment : Fragment() {

    private lateinit var ChipsRecyclerView: RecyclerView
    private lateinit var ChipsAdapter: ChipsAdapter
    private lateinit var FoodRecyclerView: RecyclerView
    private lateinit var FoodAdapter: FoodAdapter
    private var _binding: FragmentListadoBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListadoBinding.inflate(inflater, container, false)

        ChipsRecyclerView = _binding!!.chips
        ChipsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ChipsAdapter = ChipsAdapter(obtenerChips())
        ChipsRecyclerView.adapter = ChipsAdapter

        FoodRecyclerView = _binding!!.foods
        FoodRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        FoodAdapter = FoodAdapter(obtenerFoods(), { goToFood() })
        FoodRecyclerView.adapter = FoodAdapter

        return binding.root
    }

    private fun goToFood() {
        val fragment = OrderFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_host, fragment)?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun obtenerChips(): List<ChipItem> {
        return listOf(
            ChipItem("Pizza", R.drawable.pizza_slice),
            ChipItem("Burgers", R.drawable.hamburger),
            ChipItem("Tacos", R.drawable.taco),
            )
    }

    private fun obtenerFoods(): List<Food> {
        return listOf(
            Food("Big Mouth Burgers", R.drawable.bigmouth, "American food", "Av. Francisco Beiró 5201", "4.6"),
            Food("Pizzeria La Farola", R.drawable.lafarola, "Pizza", "Av. Francisco Beiró 5201", "4.8"),
            Food("Sushi Me", R.drawable.sushime, "Japanese food", "Av. Francisco Beiró 5201", "4.4")
        )
    }
}