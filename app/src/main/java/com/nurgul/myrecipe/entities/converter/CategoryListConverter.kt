package com.nurgul.myrecipe.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nurgul.myrecipe.entities.CategoryItems

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<CategoryItems>):String?{
        if (category == null){
            return (null)
        }else{
            val gson = Gson()
            val type = object : TypeToken<CategoryItems>(){

            }.type
            return gson.toJson(category,type)
        }
    }

    @TypeConverter
    fun toCategoryList ( categoryString: String):List<CategoryItems>?{
        if (categoryString == null){
            return (null)
        }else{
            val gson = Gson()
            val type = object :TypeToken<CategoryItems>(){

            }.type
            return  gson.fromJson(categoryString,type)
        }
    }
}