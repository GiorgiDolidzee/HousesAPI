package com.example.sum6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sum6.databinding.ItemHouseBinding

class HouseAdapter(private val houses: HouseData) : RecyclerView.Adapter<HouseAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHouseBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHouseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val house = houses
        holder.binding.tvTitle.text = house.content?.get(position)?.titleKA
        holder.binding.tvPublishDate.text = house.content?.get(position)?.publishDate
        holder.binding.tvDescription.text = house.content?.get(position)?.descriptionKA
        Glide.with(holder.itemView.context).load(house.content?.get(position)?.cover).into(holder.binding.imgCover)
    }

    override fun getItemCount() = houses.content!!.size

}