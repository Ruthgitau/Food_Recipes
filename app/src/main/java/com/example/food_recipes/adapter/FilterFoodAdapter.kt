package com.example.food_recipes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.food_recipes.R
import com.example.food_recipes.Model.ModelFilter

class FilterFoodAdapter(private val mContext: Context, private val items: List<ModelFilter>, private val onselectdata: onSelectData) :
    RecyclerView.Adapter<FilterFoodAdapter.ViewHolder>() {

    interface onSelectData {
        fun onSelected(modelMain: ModelFilter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_filter_food, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        //Get Image
        Glide.with(mContext)
            .load(data.strMealThumb)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imgThumb)

        holder.tvMeal.text = data.strMeal
        holder.cvFilterMeal.setOnClickListener { onselectdata.onSelected(data) }
        holder.imgFavorite.setOnClickListener {
            Toast.makeText(mContext, "Feature under development", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Class Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMeal: TextView = itemView.findViewById(R.id.tvMeal)
        val cvFilterMeal: CardView = itemView.findViewById(R.id.cvFilterMeal)
        val imgThumb: ImageView = itemView.findViewById(R.id.imgThumb)
        val imgFavorite: ImageView = itemView.findViewById(R.id.imgFavorite)
    }
}