package com.example.homework2

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.thread

// 선택된 음식들은 담는 뮤터블리스트

var SelectList = mutableListOf<ChoiceFood>()


class OrderActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOrderBinding.inflate(layoutInflater)
        binding.FoodMenu.adapter = ViewPagerAdapter(this)
        binding.FoodTab.setTabTextColors(Color.rgb(0, 0, 0),Color.rgb(255, 0, 0) )
        TabLayoutMediator(binding.FoodTab, binding.FoodMenu){
                tab, position ->
            when(position){
                0 -> tab.text = "햄버거"
                1 -> tab.text = "음료"
                else -> tab.text = "사이드"
            }
        }.attach()

        //주문 목록에 넣은 음식값의 총합을 구하는 함수
        fun totalPrice(list: List<ChoiceFood>): Int{
            var total = 0
            for(i in 0..list.size-1)
                total += list[i].foodPrice()
            return total
        }


        // lifecycleScope를 이용, selectList에 담긴 데이터 변화를 500밀리초마다 확인하여 어댑터에 반영, 그에 맞게
        // 음식값의 총합 함수도 계속 돌아가며 계산
           lifecycleScope.launch {
               whenStarted {
                   while (true) {
                       delay(500)
                       Log.d("dataLoading", "데이터 갱신중!")
                       ChoiceDataAdapter(SelectList)!!.notifyDataSetChanged()
                       binding.recyclerSelectMenu.adapter = ChoiceDataAdapter(SelectList)
                       binding.txTotalNumber.text = SelectList.size.toString()
                       binding.txTotalPrice.text = "￦${totalPrice(SelectList)}"
                   }
               }
           }



        //탭을 눌러 음식 종류를 바꾸게 하기 위해 스와이프 막음
        binding.FoodMenu.isUserInputEnabled = false
        //선택된 리스트에 대한 리싸이클러뷰 어댑터
        binding.recyclerSelectMenu.layoutManager = LinearLayoutManager(this)
        val dialog = ModalDialog()
        dialog.isCancelable = false


        binding.btnCharge.setOnClickListener {
            dialog.show(this.supportFragmentManager, "ModalDialog")
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}