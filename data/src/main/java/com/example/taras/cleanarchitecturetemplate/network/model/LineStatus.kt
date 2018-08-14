package com.example.taras.cleanarchitecturetemplate.network.model

import com.google.gson.annotations.SerializedName

data class LineStatus(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("lineStatuses")
        val statuses: List<Status>
)
