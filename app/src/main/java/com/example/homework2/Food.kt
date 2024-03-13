package com.example.homework2




open class Food(price: Int, name: String, img: Int) {
    var _price: Int = 0
    var _name: String = ""
    var _imgUri: Int = 0

    init{
        _price = price
        _name = name
        _imgUri = img
    }
    fun addPrice(): Int {
        return this._price
    }
}

class Burger(price: Int, name: String, img: Int): Food(price, name, img){}

class Beverage(price: Int, name: String, img: Int) : Food(price, name, img){

}

class Side(price: Int, name: String, img: Int): Food(price, name, img){}

class ChoiceFood(price: Int, name: String, img: Int, nums: Int): Food(price, name, img) {
    var number: Int = 0

    init {
        _price = price
        _name = name
        _imgUri = img
        number = nums
    }

    fun foodPrice(): Int {
        return this._price * number
    }
}