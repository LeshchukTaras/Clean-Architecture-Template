package com.taras.data.network.model

import com.google.gson.annotations.SerializedName

data class LineStatusModel(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("lineStatuses")
        val statuses: List<StatusModel>
)
