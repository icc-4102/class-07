package com.example.clase07

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class CovidCaseDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_covid_case_detail, container, false)
        val case = arguments?.let {
            it.get("covidCase") as CovidCase
        }
        view.findViewById<TextView>(R.id.titleLabel).text =
            "Covid Case Detail from ${case?.attributes?.Country_Region}"
        view.findViewById<TextView>(R.id.deathLabel).text = "Deaths:  ${case?.attributes?.Deaths}"
        view.findViewById<TextView>(R.id.positiveLabel).text = "Active:  ${case?.attributes?.Active}"
        view.findViewById<TextView>(R.id.negativeLabel).text = "Recovered:  ${case?.attributes?.Recovered}"
        val closeButton = view.findViewById<Button>(R.id.close_button)
        closeButton.setOnClickListener {
            val result = "result of fragment"
            setFragmentResult("REQUEST", bundleOf("DATA" to result))
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }


}