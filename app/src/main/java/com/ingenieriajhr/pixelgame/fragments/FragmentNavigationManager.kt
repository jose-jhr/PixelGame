package com.ingenieriajhr.pixelgame.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentNavigationManager(
    val fragmentManager: FragmentManager,
    private val containerId: Int,
    initFragment: Fragment,
    var position: Int
){

    private var currentFragment = initFragment

    //init fragment menu
    init {
        fragmentManager.beginTransaction()
            .replace(containerId,currentFragment)
            .commit()
    }

    fun navigationTo(fragment:Fragment){
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(containerId,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        currentFragment = fragment
        position = 1
        fragmentManager.executePendingTransactions()
    }

    fun removeCurrentFragment(){
        val transaction = fragmentManager.beginTransaction()
        if (position!=0) transaction.remove(currentFragment).commit()
    }

    fun getCurrentFragment() = currentFragment
}