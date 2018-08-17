package com.example.taras.cleanarchitecturetemplate.data

import com.example.taras.cleanarchitecturetemplate.R
import com.example.taras.cleanarchitecturetemplate.model.LineStatusPresentation
import com.taras.data.network.model.LineStatusModel
import com.taras.data.network.model.StatusModel
import com.taras.domain.model.LineStatus

fun getLineStatusModel(): LineStatusModel {
    return LineStatusModel(
            id = "id",
            name = "name",
            statuses = listOf(getStatusModel())
    )
}

fun getStatusModel(): StatusModel {
    return StatusModel(
            severityLevel = 15,
            severityLevelDescription = "severity_level_description"
    )
}

fun getExpectedLineStatus(): LineStatus {
    return LineStatus(
            id = "id",
            name = "name",
            severityLevel = "severe",
            severityLevelDescription = "severity_level_description"
    )
}

fun getLineStatus(): LineStatus {
    return LineStatus(
            id = "central",
            name = "Central Line",
            severityLevel = "minor",
            severityLevelDescription = "Minor Delays"
    )
}

fun getExpectedLineStatusPresentation(): LineStatusPresentation {
    return LineStatusPresentation(
            id = "central",
            name = "Central Line",
            severityLevel = "minor",
            severityLevelDescription = "Minor Delays",
            colourResourceId = R.color.colorOrange,
            badgeResourceId = R.drawable.ic_central
    )
}