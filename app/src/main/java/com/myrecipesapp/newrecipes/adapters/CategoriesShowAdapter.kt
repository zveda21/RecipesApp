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
import kotlinx.android.synthetic.main.show_recipes_recycler_items.view.*

class CategoriesShowAdapter(private val catergoryList: MutableList<CategoriesItem>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<CategoriesShowAdapter.ViewHolder>() {

    fun setItem(listCattegories: List<CategoriesItem>){
        catergoryList.clear()
        catergoryList.addAll(listCattegories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.show_recipes_recycler_items, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return catergoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(catergoryList[position],listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(catergoryItems: CategoriesItem, clickListener: OnItemClickListener) {
            itemView.expand_text_view.text = catergoryItems.strCategoryDescription
            itemView.show_image_meal.load(Uri.parse(catergoryItems.strCategoryThumb))
            itemView.name_category.text = catergoryItems.strCategory
            itemView.setOnClickListener {
                clickListener.onItemClicked(catergoryItems)
            }
        }
    }

}

//interface OnItemClickListener{
//    fun onItemClicked(mealName: CategoriesItem)
//}