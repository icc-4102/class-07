package com.example.clase08

import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.example.clase08.covidCases.CovidCaseDetailFragment

class Navigator(val activity: MainActivity?) {

    fun navigateToDetail(){

        val caseDetailFragment = CovidCaseDetailFragment()
        activity?.supportFragmentManager?.commit {
            this.replace(R.id.fragment_container,caseDetailFragment)
            this.addToBackStack(null)
        }
    }
    fun navigateToFavorites(){
        activity?.findNavController(R.id.fragment_container)?.navigate(R.id.action_to_favoritesFragment)
//        val favoritesFragment = FavoritesFragment()
//        activity?.supportFragmentManager?.commit {
//            this.replace(R.id.fragment_container,favoritesFragment)
//            this.addToBackStack(null)
//        }
    }

}