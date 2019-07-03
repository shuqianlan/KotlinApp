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
    lateinit var mHelloText:TextView
    lateinit var mRecycler: RecyclerView

    lateinit var hander :Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hander = Handler()

        mHelloText = findViewById(R.id.hello_text)
        mRecycler  = findViewById(R.id.recyclerview)

        mHelloText.setOnClickListener{
            println("${this.toString()}") // 此处this是MainActivity
            println("TextView is clicked...")
        }

        val items = arrayListOf("1", "2", "3", "4")
        mRecycler.layoutManager = LinearLayoutManager(this)
        mRecycler.adapter = object : RecyclerView.Adapter<ItemHolder>() {
            override fun getItemCount(): Int = items.size

            override fun onBindViewHolder(holder: ItemHolder, position: Int) {
                holder.onBind(items.get(position))
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
                ItemHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))

        }

        val str = "abc"
        println("$TAG str.toList:${str.toList()}")

//        val bean = Bean()
//        bean.postponeComputation(100) { println("HAHHAHAH") }  // lambda作为最后一个表达式可以置于外部。重用匿名类实例
//
//        bean.postponeComputation(200, { println("HAHAHAHA") }) // 旧款
//
//        bean.postponeComputation(300, object : Runnable {      // 显示lambda写法，不过此处会每次调用创建一个Runnable实例
//            override fun run() {
//                { println("HAHAHAHA") }
//            }
//        })
//
// SAM构造方法
//        val listener = View.OnClickListener {view ->
//            val text = when(view.id) {
//                R.id.recyclerview -> "RecyclerView"
//                R.id.hello_text -> "HelloText"
//                else -> "Unknown View"
//            }
//            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
//        }
//        mHelloText.setOnClickListener(listener)
    }

    class ItemHolder: RecyclerView.ViewHolder, View.OnClickListener {
        lateinit var bean: String

        // 声明构造器.
        constructor(itemView: View): super(itemView) {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            println("Item: $bean")
        }

        fun onBind(bean: String) {
            if (itemView is TextView) {
                itemView.setText(bean)
            }
            this.bean = bean
        }
    }
}
