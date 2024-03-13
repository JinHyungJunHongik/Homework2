package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework2.databinding.FragmentBurgerBinding

val BurgerList = listOf<Burger>(
    Burger(4600, "싸이버거", R.drawable.psyburger),
    Burger(3500, "불고기버거", R.drawable.bulgogieburger),
    Burger(4800, "스테이크버거", R.drawable.beefburger),
    Burger(3700, "치즈버거", R.drawable.cheeseburger),
    Burger(4600, "미트볼버거", R.drawable.meatballburger),
    Burger(4100, "새우버거", R.drawable.shirimpburger)
)
class BurgerFragment : Fragment() {
    lateinit var binding: FragmentBurgerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBurgerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.burgerList.adapter = ViewAdapter(BurgerList)
        binding.burgerList.layoutManager = GridLayoutManager(this.context, 3)
        super.onViewCreated(view, savedInstanceState)
    }
}