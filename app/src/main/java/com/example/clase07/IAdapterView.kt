package com.example.clase07

interface IAdapterView{
    fun addItem(item: Any)
    val onClickListener: OnClickListener
}