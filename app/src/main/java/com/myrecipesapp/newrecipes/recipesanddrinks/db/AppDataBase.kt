package com.myrecipesapp.newrecipes.recipesanddrinks.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.CategoriesItem

@Database(entities = [CategoriesItem::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        private const val DBNAME = "mydb.db"
        private var db: AppDataBase? = null
        private val lock = Any()
        fun getInstance(context: Context): AppDataBase {
            synchronized(lock){
                db?.let {
                    return it
                }
                val instance = Room.databaseBuilder(context,AppDataBase::class.java, DBNAME).build()
                db = instance
                return instance
            }
        }

    }
    abstract fun categoriesDao():CategoriesDao
}