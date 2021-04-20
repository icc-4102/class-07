package com.example.clase07

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson


class CovidCasesViewModel(application: Application) : AndroidViewModel(application) {

     var cases: Array<CovidCase>
     val caseList = mutableListOf<CovidCase>()
     val myCases =  MutableLiveData<MutableList<CovidCase>>()

     init {
          val gson = Gson()
          val fileName = "Cases.json"
          val file = application.assets.open(fileName).bufferedReader()
          cases = gson.fromJson(file,Array<CovidCase>::class.java)
     }

     fun addCase(){
          caseList.add(cases[0])
          myCases.postValue(caseList)
          cases.shuffle()
     }





}