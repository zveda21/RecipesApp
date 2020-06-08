package com.myrecipesapp.newrecipes.recipesanddrinks.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentContainerView

import com.myrecipesapp.newrecipes.R

class EmptyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_empty, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        childFragmentManager.beginTransaction()?.apply {
//            add(R.id.frame_fragment, RecipesShowFragment())
//            addToBackStack(null)
//            commit()}
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            add(R.id.frame_fragment, RecipesShowFragment())
          //  addToBackStack(null)
            commit()
        }
    }
}
