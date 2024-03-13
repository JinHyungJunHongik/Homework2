package com.example.homework2

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
// Burger, Beverage, Side 모두 Food의 자식이라 어댑터 코드 활용을 위해 Food로 리스트 데이터 타입 선언
class ViewAdapter(val data: List<Food>) : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView
        val food: TextView
        val price: TextView
        val click: LinearLayout
        init{
            img = view.findViewById<ImageView>(R.id.img_food)
            food = view.findViewById<TextView>(R.id.tx_food)
            price = view.findViewById<TextView>(R.id.tx_price)
            click = view.findViewById<LinearLayout>(R.id.linearLayout_Food)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_data, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        fun searchData(list: List<ChoiceFood>, str: String): Pair<Boolean, Int> {
            var find: Boolean = false
            var idx: Int = 0
            for(i in 0..list.size-1){
                if(list[i]._name == str){
                    find = true
                    idx = i
                    break
                }
            }
            return Pair(find, idx)
        }

        holder.img.setImageResource(data[position]._imgUri)
        holder.food.text = data[position]._name
        holder.price.text = "￦${data[position]._price}"
        // 뷰를 클릭하면 selectList에 해당 정보를 담음, 음식 개수의 기본값은 1
        // 만약 이미 selectList에 있는 경우, 리스트에 추가하지 않고 개수만 +1 (searchData함수 사용)
        holder.click.setOnClickListener {
            var input = searchData(SelectList, data[position]._name)
            var inputList = input.toList()
            if(inputList[0] == true){
                SelectList[inputList[1] as Int].number++
            }
            else {
                SelectList.add(
                    ChoiceFood(
                        data[position]._price,
                        data[position]._name,
                        data[position]._imgUri,
                        1
                    )
                )
            }
        }
    }
}