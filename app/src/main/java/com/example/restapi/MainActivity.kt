package com.example.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.restapi.pojo.User
import com.example.restapi.remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private var userList =  ArrayList<User>()
    private lateinit var viewAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spaceBeetwenCards =TopSpacingItemDecoration(30)



        viewAdapter = UserAdapter(userList)
        postsRecyclerView.adapter = viewAdapter
        postsRecyclerView.addItemDecoration(spaceBeetwenCards)

        loadApiData()
    }

    private fun loadApiData(){
        val service=RetrofitClient.retrofitInstance()
        val call=service.getAllUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.map { userList.add(it) }
                viewAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Error: no pudimos recuperar los posts desde el api",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}