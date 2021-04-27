package com.example.clase07.covidCases

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.clase07.CovidCase
import com.example.clase07.MainActivity
import com.example.clase07.Navigator
import com.google.gson.Gson


class CovidCasesViewModel(application: Application) : AndroidViewModel(application) {

     var cases: Array<CovidCase>
     val caseList = mutableListOf<CovidCase>()
     val myCases =  MutableLiveData<MutableList<CovidCase>>()
     val selectedCase = MutableLiveData<CovidCase>()
     val favoritesCountries = MutableLiveData<MutableList<CovidCase>>()
     lateinit var navigator: Navigator

     init {
          val gson = Gson()
          val fileName = "Cases.json"
          val file = application.assets.open(fileName).bufferedReader()
          cases = gson.fromJson(file,Array<CovidCase>::class.java)
          //Agregamos todos los casos a la lista
          myCases.postValue(cases.toMutableList())
     }

     fun setNavigator(activity: MainActivity?){
          navigator = Navigator(activity)
     }

     fun selectCase(item: CovidCase){
          selectedCase.postValue(item)
     }

     fun addCase(item: CovidCase){
          var tempList= favoritesCountries.value ?: mutableListOf<CovidCase>()
          tempList?.add(item)
          favoritesCountries.postValue(tempList)
     }





}