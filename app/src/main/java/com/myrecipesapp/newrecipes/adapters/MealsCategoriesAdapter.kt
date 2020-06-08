package com.myrecipesapp.newrecipes.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.interfaces.OnItemClickListener
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.CategoriesItem
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.Meal
import kotlinx.android.synthetic.main.meals_categoris_list_recycler_item.view.*

class MealsCategoriesAdapter (private val mealsCategoriesList:MutableList<Meal>,private val listener: OnItemClickListener):RecyclerView.Adapter<MealsCategoriesAdapter.ViewHolder> (){


    fun setItems(listMeals:List<Meal>){
        mealsCategoriesList.clear()
        mealsCategoriesList.addAll(listMeals)
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.meals_categoris_list_recycler_item,parent,false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
      return  mealsCategoriesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mealsCategoriesList[position],listener)
    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun onBind(mealsCategory:Meal,clickListener: OnItemClickListener){
            itemView.categoriesClickImage.load(Uri.parse(mealsCategory.strMealThumb))
            itemView.categorisSearchedmealName.text = mealsCategory.strMeal

            itemView.setOnClickListener {
                clickListener.onItemClicked(mealsCategory)
            }
        }

    }
}
//interface OnItemClickListenerSec {
//    fun onItemClicked(mealName: Meal)
//}