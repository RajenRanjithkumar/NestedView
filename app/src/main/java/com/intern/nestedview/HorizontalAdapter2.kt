package com.intern.nestedview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.intern.nestedview.model.Item
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_view1.view.*
import kotlinx.android.synthetic.main.item_view2.view.*


class HorizontalAdapter2 (private val dataList: MutableList<Item>): RecyclerView.Adapter<HorizontalAdapter2.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view2, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        //val imagetype1 = holder.itemView.image_type1
        //val title1 = holder.itemView.title1


        holder.textView.text = "${data.title}"
        holder.subtextView.text = "${data.subTitle}"
        //holder.textView.text = "Testing"

        Picasso.get()
            .load(data.imgSrc)
            .into(holder.imageView)
        //title1.text = text1

    }

    override fun getItemCount(): Int =dataList.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var textView : TextView = itemView.title2
        var subtextView : TextView = itemView.subtitle
        val imageView: ImageView = itemView.image_type2

    }
}