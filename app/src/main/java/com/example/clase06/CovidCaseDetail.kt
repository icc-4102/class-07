package com.example.clase06

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CovidCaseDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_case_detail)
        //Aca se obtiene el objeto  del intent y se define su tipo
        val case = intent.getParcelableExtra<CovidCase>("covidCase")
        findViewById<TextView>(R.id.titleLabel).text = "Covid Case Detail from ${case?.date}"
        findViewById<TextView>(R.id.dateLabel).text = "${case?.date}"
        findViewById<TextView>(R.id.positiveLabel).text = "${case?.positive}"
        findViewById<TextView>(R.id.negativeLabel).text = "${case?.negative}"
        val closeButton = findViewById<Button>(R.id.close_button)
    }

    fun setResult(view: View){
        val data = Intent().apply{
            putExtra("DATA","Result from CovidCaseDetail")
        }
        setResult(201,data)
        finish()
    }


}