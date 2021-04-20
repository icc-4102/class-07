package com.example.clase06

interface IAdapterView{
    fun addItem(item: Any)
    val onClickListener: OnClickListener
}