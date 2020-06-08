package com.myrecipesapp.newrecipes.recipesanddrinks.view.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.adapters.FragmentsViewPagerAdapter
import com.myrecipesapp.newrecipes.animationController.ZoomOutPageTransformer
import com.myrecipesapp.newrecipes.internetcheck.App
import com.myrecipesapp.newrecipes.recipesanddrinks.view.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :App() {
    private val catFragment = CategoriesMealsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Foods and Drinks"
        setUpViewPager2(view_pager)
        tabLayoutMediatorSettings()

    }

    private fun setUpViewPager2(viewPager: ViewPager2) {

        val fragmentAdapter = FragmentsViewPagerAdapter(this)
        fragmentAdapter.addFragment(EmptyFragment())
        fragmentAdapter.addFragment(DrinksFragment())
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        viewPager.adapter = fragmentAdapter
    }

    private fun tabLayoutMediatorSettings() {
        TabLayoutMediator(tab_layout, view_pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Meals"
                }
                1 -> {
                    tab.text = "Drinks"
                }
            }
        }.attach()
    }

//    override fun sendMessageTo(message: String) {
//            catFragment.setMessage(message)
//    }
}
