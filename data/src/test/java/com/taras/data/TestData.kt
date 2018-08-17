package com.taras.data

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
