package com.example.busapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BusDetailActivity : AppCompatActivity() {

    private val busInfo by lazy { intent.getSerializableExtra("busInfo") as Bus }

    private val items = ArrayList<BusModel>()

    lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_detali)
        val detailRecyclerView = findViewById<RecyclerView>(R.id.rv_detail)

        items.addAll(busInfo.data)

        adapter = RecyclerAdapter(items)
        detailRecyclerView.layoutManager = LinearLayoutManager(this)
        detailRecyclerView.adapter = adapter
    }
}