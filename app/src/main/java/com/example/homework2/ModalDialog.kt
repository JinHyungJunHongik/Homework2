package com.example.homework2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2.databinding.ModalSelectfoodBinding

class ModalDialog: DialogFragment() {
    lateinit var binding: ModalSelectfoodBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ModalSelectfoodBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fun totalPrice(list: List<ChoiceFood>): Int{
            var total = 0
            for(i in 0..list.size-1)
                total += list[i].foodPrice()
            return total
        }
        //직접 만든 다이얼로그 크기 조정 관련
        dialog!!.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT)
        binding.modalFoodList.adapter = modalViewAdapter(SelectList)
        binding.modalFoodList.layoutManager = LinearLayoutManager(this.context)
        binding.modalTotalPrice.text = "총 ￦${totalPrice(SelectList)}"
        binding.btnModalNegative.setOnClickListener {
            this.dismiss()
        }
        binding.btnModalPositive.setOnClickListener {
            val intent = Intent(activity, PaymentActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}