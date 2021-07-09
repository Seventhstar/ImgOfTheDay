package com.seventhstar.imgoftheday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seventhstar.imgoftheday.model.Wish
import com.seventhstar.imgoftheday.view.WishesFragment.*
import com.squareup.picasso.Picasso

class WishesFragmentAdapter(private var onItemViewClickListener: OnItemViewClickListener?) :
    RecyclerView.Adapter<WishesFragmentAdapter.WishesViewHolder>() {

    private var wishesList: List<Wish> = listOf()

    fun setData(data: List<Wish>) {
        wishesList = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    class WishesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(wish: Wish) {
            itemView.findViewById<TextView>(R.id.wish_name).text = wish.name
            val icon = itemView.findViewById<ImageView>(R.id.wish_icon)


            Picasso.get()
                .load(wish.imageUrl)
                .into(icon);

//            itemView.setOnClickListener()
//            {
//                onItemViewClickListener?.onItemViewClick(film)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishesViewHolder {
        return WishesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.wish_list_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: WishesViewHolder, position: Int) {
        val wish = wishesList[position]
        holder.bind(wish)
    }

    override fun getItemCount(): Int {
        return wishesList.size
    }

}
