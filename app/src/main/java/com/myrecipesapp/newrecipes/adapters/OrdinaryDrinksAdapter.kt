package com.myrecipesapp.newrecipes.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel.Drink
import kotlinx.android.synthetic.main.ordinary_drinks_recycler_items.view.*

class OrdinaryDrinksAdapter(private val ordinaryDrinkList: MutableList<Drink>) :
    RecyclerView.Adapter<OrdinaryDrinksAdapter.ViewHolder>() {

    fun setItemDriks(listOfOrdinaryDrinks:List<Drink>){
        ordinaryDrinkList.addAll(listOfOrdinaryDrinks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.ordinary_drinks_recycler_items, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return ordinaryDrinkList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(ordinaryDrinkList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(drinkOrdinary: Drink) {
            itemView.ordinary_drinks_image.load(Uri.parse(drinkOrdinary.strDrinkThumb))
            itemView.drinks_ordinary_name.text = drinkOrdinary.strDrink

        }
    }
}