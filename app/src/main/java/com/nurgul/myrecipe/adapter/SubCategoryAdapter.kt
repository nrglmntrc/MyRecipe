package com.nurgul.myrecipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurgul.myrecipe.databinding.ItemRvSubCategoryBinding
import com.nurgul.myrecipe.entities.MealsItems

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListener? = null
    var ctx: Context? = null
    var arrSubCategory = ArrayList<MealsItems>()

    inner class RecipeViewHolder(val binding: ItemRvSubCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(arrData: List<MealsItems>) {
        arrSubCategory = arrData as ArrayList<MealsItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding= ItemRvSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecipeViewHolder(binding)   }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    fun setClickListener(listener1: SubCategoryAdapter.OnItemClickListener) {
        listener = listener1
    }
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        with(holder){
            with(arrSubCategory[position]){
               binding.tvDishName.text=arrSubCategory[position].strMeal
                Glide.with(ctx!!).load(arrSubCategory[position].strMealThumb).into(binding.imgDish)

                holder.itemView.rootView.setOnClickListener {
                    listener!!.onClicked(arrSubCategory[position].idMeal)
                }
            }
        }



    }

    interface OnItemClickListener {
        fun onClicked(id: String)
    }

}