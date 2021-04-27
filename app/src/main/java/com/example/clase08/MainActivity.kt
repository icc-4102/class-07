package com.example.clase08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//         supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<CovidCasesFragment>(R.id.fragment_container,"CovidCases")
//        }
    }

}