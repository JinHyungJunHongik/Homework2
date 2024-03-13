package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework2.databinding.FragmentSideBinding

val SideList = listOf<Side>(
    Side(1900, "감자튀김", R.drawable.potato),
    Side(1500, "코울슬로", R.drawable.salad),
    Side(1000, "치즈스틱", R.drawable.cheesestick),
    Side(1800, "치즈볼", R.drawable.cheeseball)
)

class SideFragment : Fragment() {
    lateinit var binding: FragmentSideBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSideBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.SideList.adapter = ViewAdapter(SideList)
        binding.SideList.layoutManager = GridLayoutManager(this.context, 3)
        super.onViewCreated(view, savedInstanceState)
    }
}