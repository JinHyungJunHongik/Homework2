package com.example.homework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


//selectList에 담긴 음식 리스트에 관란 리싸이클러뷰 어댑터 및 홀더
class ChoiceDataAdapter(val data: List<ChoiceFood>) : RecyclerView.Adapter<ChoiceDataAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val food: TextView
        val nums: TextView
        val price: TextView
        val delete: ImageView
        val plus: ImageView
        val minus: ImageView
        init{
            nums = view.findViewById<TextView>(R.id.tx_select_food_nums)
            food = view.findViewById<TextView>(R.id.tx_select_food)
            price = view.findViewById<TextView>(R.id.select_food_price)
            delete = view.findViewById<ImageView>(R.id.btn_select_delete)
            plus = view.findViewById<ImageView>(R.id.btn_plus)
            minus = view.findViewById<ImageView>(R.id.btn_mius)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.choice_data, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nums.text = data[position].number.toString()
        holder.food.text = data[position]._name
        holder.price.text = "￦${data[position].foodPrice()}"
        //지우는 버튼
        holder.delete.setOnClickListener {
            SelectList.removeAt(position)
        }
        //개수 추가 버튼
        holder.plus.setOnClickListener {
            data[position].number++
            holder.nums.text = data[position].number.toString()
            holder.price.text = "￦${data[position].foodPrice()}"
        }
        
        //개수 빼는 버튼, 1개에서 누를 시 예외 발생 (0으로 나누게 만들어 산술 오류 발생시키기) 시켜서 관련 토스트 메시지 출력하게 만듬
        holder.minus.setOnClickListener {
            try {
                data[position].number--
                var checker = 100 / data[position].number
            } catch (e: ArithmeticException) {
                Toast.makeText(holder.itemView.context, "1개 이하로 주문할 수 없습니다.", Toast.LENGTH_SHORT)
                    .show()
                data[position].number = 1
                holder.nums.text = data[position].number.toString()
                holder.price.text = "￦${data[position].foodPrice()}"
            }
        }
    }
}