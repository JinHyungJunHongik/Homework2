package com.example.homework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class modalViewAdapter(val data: List<ChoiceFood>) : RecyclerView.Adapter<modalViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val food: TextView
        val nums: TextView
        val price: TextView
        init{
            food = view.findViewById<TextView>(R.id.tx_modalFoodName)
            nums = view.findViewById<TextView>(R.id.tx_modalFoodnums)
            price = view.findViewById<TextView>(R.id.tx_modalFoodprice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.modal_data, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.food.text = data[position]._name
        holder.nums.text = "X${data[position].number}"
        holder.price.text = data[position].foodPrice().toString()
    }
}
