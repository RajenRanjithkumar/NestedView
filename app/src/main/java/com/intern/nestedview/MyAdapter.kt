package com.intern.nestedview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.intern.nestedview.model.Response
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter (private val dataList: MutableList<Response>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    private val viewPool = RecyclerView.RecycledViewPool()

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        val category = holder.itemView.category

        val head = "${data.title}"
        category.text = head

        holder.recyclerView.apply {

            layoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
            if(data.type == "type1")
            {
                adapter = HorizontalAdapter1(data.items)
            }
            else
                adapter = HorizontalAdapter2(data.items)




        }


    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.nestedRecycler

    }


}
