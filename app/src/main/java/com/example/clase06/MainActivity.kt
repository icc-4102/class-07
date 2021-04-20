package com.example.clase06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.Gson


val REQUEST_CODE = 200

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var cases: Array<CovidCase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val covidCasesFragment =
            supportFragmentManager.findFragmentById(R.id.covid_cases_fragment) as CovidCasesFragment
        val adapter  = CovidRecyclerViewAdapter(this)
        covidCasesFragment.adapter = adapter
        covidCasesFragment.recyclerView.adapter = adapter

        //Libreria externa para transformar un json a data class
        val gson = Gson()
        cases = gson.fromJson(dataJson, Array<CovidCase>::class.java)

        //Boton que agrega un caso al recycler view
        val addCaseButton = findViewById<Button>(R.id.add_case_button)
        addCaseButton.setOnClickListener {
            covidCasesFragment.adapter.addItem(cases[0])
//            // Metodo que lo ordena nuevamente, se utiliza para que no entregue el mismo siempre
            cases.shuffle()
        }
    }

    override fun onClickItem(item: Any) {
        if (item is CovidCase) {
            val intent = Intent(this, CovidCaseDetail::class.java)
            val case = item as CovidCase
            //Esta es la forma correcta de pasar data por el intent. Lo que se vio en clase puede ser dependiendo del tipo
            intent.putExtra("covidCase", case)
            this.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200) {
            if (resultCode == 201 && data != null) {
                data.apply{
                    val string  = this.getStringExtra("DATA")
                    println(string)
                }
            }
        }

    }


}