package com.example.growgh_project

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FeedsAdapter(val context: Context) :
    RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder>() {
    var items: ArrayList<String> = ArrayList()

    class FeedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)

        return FeedsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedsViewHolder, position: Int) {
        Glide.with(context).load(items[position]).error(R.drawable.error_img).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(urlList: ArrayList<String>) {
        items.clear()
        items.addAll(urlList)
        this.notifyDataSetChanged()
    }
}