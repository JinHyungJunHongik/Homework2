package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework2.databinding.FragmentBeverageBinding

val BeverageList = listOf<Beverage>(
    Beverage(1500, "콜라", R.drawable.coke),
    Beverage(1500, "사이다", R.drawable.cider),
    Beverage(2000, "레몬에이드", R.drawable.ade),
    Beverage(1800, "아메리카노", R.drawable.coffee),
    Beverage(1600, "오렌지주스", R.drawable.juice)
)
class BeverageFragment : Fragment() {
    lateinit var binding: FragmentBeverageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeverageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.BeverageList.adapter = ViewAdapter(BeverageList)
        binding.BeverageList.layoutManager = GridLayoutManager(this.context, 3)
        super.onViewCreated(view, savedInstanceState)
    }

}