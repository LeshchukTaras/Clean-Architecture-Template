package com.taras.data.network.model

import com.google.gson.annotations.SerializedName

data class StatusModel(
        @SerializedName("statusSeverity")
        val severityLevel: Int,
        @SerializedName("statusSeverityDescription")
        val severityLevelDescription: String
)
