package com.example.clase07

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CovidCasesFragment : Fragment(),OnClickListener {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CovidRecyclerViewAdapter
    private val viewModel: CovidCasesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_covid_casses, container, false)
        adapter = CovidRecyclerViewAdapter(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.covid_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.myCases.observe(viewLifecycleOwner, Observer {
            adapter.set(it)
        })
        val button = view.findViewById<Button>(R.id.add_case_button)
        button.setOnClickListener {
           viewModel.addCase()
        }
        return view
    }

    override fun onClickItem(item: Any) {
        if (item is CovidCase) {
            val bundle = Bundle()
            bundle.putParcelable("covidCase", item)
            setFragmentResultListener("REQUEST"){ requestKey: String, bundle: Bundle ->
                if (requestKey == "REQUEST") {
                   val result = bundle.get("DATA")
                    println(result)
                }
            }
            val fragmentTwo = CovidCaseDetail()
            fragmentTwo.arguments = bundle
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.fragment_container,fragmentTwo)
                this.addToBackStack(null)
            }
        }
    }

}