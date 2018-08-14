package com.taras.data.network.model

import com.google.gson.annotations.SerializedName

data class StatusModel(
        @SerializedName("statusSeverity")
        val severityLevel: String,
        @SerializedName("statusSeverityDescription")
        val severityLevelDescription: String
)
