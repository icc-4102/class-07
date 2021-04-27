package com.example.clase08

interface IAdapterView{
    fun addItem(item: Any)
    val onClickListener: OnClickListener
}