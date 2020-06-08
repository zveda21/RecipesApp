package com.myrecipesapp.newrecipes.recipesanddrinks.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.CategoriesItem

@Dao
interface CategoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(categoriesList:List<CategoriesItem>?)

    @Query("SELECT * FROM categories")
    suspend fun loadCategories():List<CategoriesItem>?
}


