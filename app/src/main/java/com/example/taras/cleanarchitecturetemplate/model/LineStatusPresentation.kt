package com.example.taras.cleanarchitecturetemplate.model

class LineStatusPresentation(
        val id: String,
        val name: String,
        val severityLevel: String,
        val severityLevelDescription: String,
        val colourResourceId: Int,
        val badgeResourceId: Int
)