package com.myrecipesapp.newrecipes.recipesanddrinks.models.categories

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>? = null
)