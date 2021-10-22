package com.example.sum6

import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sum6.api.ApiService
import com.example.sum6.api.RetrofitInstance
import com.example.sum6.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun init() {
        retrofitService()
    }

    private fun retrofitService() {
        val api = RetrofitInstance.retrofit!!.create(ApiService::class.java)

        api.fetchAllData().enqueue(object : Callback<HouseData>{
            override fun onResponse(call: Call<HouseData>, response: Response<HouseData>) {
                d("Data", "Data Loaded")
                d("Data", "${response.body()!!}")
                setDataOnRecycler(response.body()!!)
            }
            override fun onFailure(call: Call<HouseData>, t: Throwable) {
                d("Data", "Failed")
            }
        })

    }

    private fun setDataOnRecycler(houses: HouseData) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = HouseAdapter(houses)
        }
    }

}