package com.example.food_recipes.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.food_recipes.R
import com.example.food_recipes.Model.ModelMain

class MainAdapter(private val mContext: Context, private val items: List<ModelMain>, private val onselectdata: onSelectData) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface onSelectData {
        fun onSelected(modelMain: ModelMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_categories, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        //Get Image
        Glide.with(mContext)
            .load(data.strCategoryThumb)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imgKategori)

        holder.tvKategori.text = data.strCategory
        holder.cvKategori.setOnClickListener {
            onselectdata.onSelected(data)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Class Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvKategori: TextView = itemView.findViewById(R.id.tvKategori)
        val cvKategori: CardView = itemView.findViewById(R.id.cvKategori)
        val imgKategori: ImageView = itemView.findViewById(R.id.imgKategori)
    }
}