package com.nurgul.myrecipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurgul.myrecipe.R
import com.nurgul.myrecipe.databinding.ItemRvMainCategoryBinding
import com.nurgul.myrecipe.entities.CategoryItems
import com.nurgul.myrecipe.entities.Recipes

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var ctx: Context? = null
    var arrMainCategory = ArrayList<CategoryItems>()
    inner class RecipeViewHolder(val binding: ItemRvMainCategoryBinding): RecyclerView.ViewHolder(binding.root){

    }

    fun setData(arrData : List<CategoryItems>){
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        with(holder){
            with(arrMainCategory[position]){
                binding.tvDishName.text = arrMainCategory[position].strcategory
                Glide.with(ctx!!).load(arrMainCategory[position].strcategorythumb).into(binding.imgDish)
                holder.itemView.rootView.setOnClickListener {
                    listener!!.onClicked(arrMainCategory[position].strcategory)
                }
            }
        }


    }

    interface OnItemClickListener{
        fun onClicked(categoryName:String)
    }

}