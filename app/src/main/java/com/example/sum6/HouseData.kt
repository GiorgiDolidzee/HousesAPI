package com.example.sum6


import com.google.gson.annotations.SerializedName

data class HouseData(
    @SerializedName("content")
    val content: List<Content>?
)