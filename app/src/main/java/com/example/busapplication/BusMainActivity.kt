package com.example.busapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class BusMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_main)

        val busStopNumber = findViewById<TextView>(R.id.et_bus_stop_number)
        val searchButton = findViewById<Button>(R.id.btn_search)

        searchButton.setOnClickListener {
            val busStopNumberString = busStopNumber.text.toString()

            if (busStopNumberString.isNotEmpty()) {
                loadPostmanBusInfo(busStopNumberString)
            } else {
                Toast.makeText(this, "모든 정보를 바르게 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadRealBusInfo() { // 공공 api
        val serviceKey = resources.getString(R.string.api_service_key)
        val serviceKeyDecoded: String = URLDecoder.decode(serviceKey, "UTF-8")

        Log.e("serviceKeyDecoded", serviceKeyDecoded)
        RetrofitManager.retrofit.getBusInfo(
                serviceKeyDecoded,
                "DJB30300052",
                "DJB8005621",
                25
        ).enqueue(object : Callback<Bus> {
            override fun onResponse(call: Call<Bus>, response: Response<Bus>) {
                Log.e("hi", response.body().toString())
            }

            override fun onFailure(call: Call<Bus>, t: Throwable) {
                Toast.makeText(this@BusMainActivity, "데이터를 가져오는 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loadPostmanBusInfo(busStopNumber: String) { //mock api
        val serviceKey = resources.getString(R.string.api_service_key)
        val serviceKeyDecoded: String = URLDecoder.decode(serviceKey, "UTF-8")

        RetrofitManager.postmanRetrofit.getPostmanBusInfo(
                serviceKeyDecoded,
                busStopNumber,
                "25"
        ).enqueue(object : Callback<Bus> {
            override fun onResponse(call: Call<Bus>, response: Response<Bus>) {
                val data = response.body() as Bus
                val intent = Intent(this@BusMainActivity, BusDetailActivity::class.java)
                intent.putExtra("busInfo", data)
                startActivity(intent)
            }

            override fun onFailure(call: Call<Bus>, t: Throwable) {
                Toast.makeText(this@BusMainActivity, "데이터를 가져오는 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}