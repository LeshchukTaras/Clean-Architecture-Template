package com.example.taras.cleanarchitecturetemplate.network.model

import com.google.gson.annotations.SerializedName

data class Status(
        @SerializedName("statusSeverity")
        val severityLevel: String,
        @SerializedName("statusSeverityDescription")
        val severityLevelDescription: String
)
