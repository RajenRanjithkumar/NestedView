package com.intern.nestedview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.intern.nestedview.model.Item
import com.intern.nestedview.model.Reqres
import com.intern.nestedview.model.Response
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.*

class MainActivity : AppCompatActivity() {

    private val dataList: MutableList<Response> = mutableListOf()
    //private val horizontaldataList: MutableList<Item> = mutableListOf()

    private lateinit var myAdapter: MyAdapter

    private lateinit var hAdapter: HorizontalAdapter1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MyAdapter(dataList)
        //hAdapter = HorizontalAdapter1(horizontaldataList)


        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        my_recycler_view.adapter = myAdapter

        //nestedRecycler.layoutManager = LinearLayoutManager(this)
       // nestedRecycler.addItemDecoration(DividerItemDecoration(this, OrientationHelper.HORIZONTAL))
        //nestedRecycler.adapter = hAdapter


        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://gaming-panda.df.r.appspot.com/intern_test")
            .build()
            .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres> {
                override fun onResponse(response: Reqres) {

                    dataList.clear()
                    dataList.addAll(response.response)
                    myAdapter.notifyDataSetChanged()



                }

                override fun onError(anError: ANError?) {

                    Toast.makeText(this@MainActivity, "something went wrong", Toast.LENGTH_SHORT).show()

                }


            })


        /*AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://gaming-panda.df.r.appspot.com/intern_test")
            .build()
            .getAsObject(Response::class.java, object : ParsedRequestListener<Response> {
                override fun onResponse(item: Response) {

                    horizontaldataList.clear()
                    horizontaldataList.addAll(item.items)
                    hAdapter.notifyDataSetChanged()



                }

                override fun onError(anError: ANError?) {

                    Toast.makeText(this@MainActivity, "something went wrong", Toast.LENGTH_SHORT).show()

                }


            })*/



    }
}