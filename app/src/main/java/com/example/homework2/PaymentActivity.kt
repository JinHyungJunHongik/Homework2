package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework2.databinding.ActivityPaymentBinding
import kotlin.random.Random

class PaymentActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        var random = Random.nextInt(9999) + 1
        binding.orderNumber.text = random.toString()
        binding.btnGoToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            SelectList.clear()
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}