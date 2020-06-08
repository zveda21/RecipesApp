package com.myrecipesapp.newrecipes.recipesanddrinks.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.adapters.CategoriesShowAdapter
import com.myrecipesapp.newrecipes.interfaces.Configurations
import com.myrecipesapp.newrecipes.interfaces.OnItemClickListener
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.CategoriesItem
import com.myrecipesapp.newrecipes.recipesanddrinks.viewModels.ShowRecipesViewModel
import kotlinx.android.synthetic.main.fragment_recipes_show.*


class RecipesShowFragment : Fragment(), OnItemClickListener, Configurations {
    private var categoriesMealsFragment = CategoriesMealsFragment()
    private val categoriesViewModel by lazy {
        ViewModelProviders.of(this).get(ShowRecipesViewModel::class.java)
    }
    private var categoryRecipes: MutableList<CategoriesItem> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes_show, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showCategoriesRecipes()
        categoriesViewModel.getCategories()
//        categoriesViewModel = ViewModelProviders.of(this).get(ShowRecipesViewModel::class.java)
        observeStates()
    }

    private fun observeStates() {
        categoriesViewModel.recipesMutableLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("ViewFragmentModel-", it.toString())
            (recips_show_recycler.adapter as CategoriesShowAdapter).setItem(it)

        })
        categoriesViewModel.getProgressState().observe(viewLifecycleOwner, Observer {
            if (it) {
                progressBar1.visibility = View.VISIBLE
            } else
                progressBar1.visibility = View.GONE
        })


        categoriesViewModel.getError().observe(viewLifecycleOwner, Observer {
            if (it) {
                showAlertDialog()
            }
        })
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(activity,R.style.AlertDialogTheme)
        builder.apply {
          //  setTitle("SOMETHING WENT WRONG")
            setTitle(Html.fromHtml("<font color='#F78411'>SOMETHING WENT WRONG</font>"))
            setMessage("Please check your internet connection")
            setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
            }
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showCategoriesRecipes() {
        recips_show_recycler.layoutManager = LinearLayoutManager(activity)
        recips_show_recycler.adapter = CategoriesShowAdapter(categoryRecipes, this)
    }

    override fun <T> onItemClicked(mealName: T) {
        if (mealName is CategoriesItem) {
            Log.d("CategoryName -- +", mealName.strCategory)
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val fragmentBundle: Bundle = Bundle()
            fragmentBundle.putString("mealName", mealName.strCategory)
            categoriesMealsFragment.arguments = fragmentBundle
            Log.d("Name**", mealName.strCategory)
            transaction?.replace(R.id.frame_fragment, categoriesMealsFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }

    override fun onProgressBar(value: Boolean) {
        if (value) {
            progressBar1.visibility = View.VISIBLE
        } else progressBar1.visibility = View.GONE
    }


}
