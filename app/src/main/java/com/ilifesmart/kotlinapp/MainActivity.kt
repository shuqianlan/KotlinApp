package com.ilifesmart.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    private lateinit var mRecycler: RecyclerView
    val items = listOf("Item-1", "Item-2", "Item-3", "Item-4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecycler = findViewById(R.id.recyclerview)
        mRecycler.layoutManager = LinearLayoutManager(this)
        mRecycler.adapter = object : RecyclerView.Adapter<ItemHolder>() {
            override fun getItemCount(): Int = items.size

            override fun onBindViewHolder(holder: ItemHolder, position: Int) {
                holder.onBind(items.get(position))
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
                ItemHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))
        }

    }

    class ItemHolder: RecyclerView.ViewHolder, View.OnClickListener {
        lateinit var bean: String

        // 声明构造器.
        constructor(itemView: View): super(itemView) {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            (v as? TextView)?.let { println("view.text:${v.text}") }
        }

        fun onBind(bean: String) {
            (itemView as? TextView)?.setText(bean)
            this.bean = bean
        }
    }
}
