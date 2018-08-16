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
            severityLevel = "severity_level",
            severityLevelDescription = "severity_level_description"
    )
}

fun getExpectedLineStatus(): LineStatus {
    return LineStatus(
            id = "id",
            name = "name",
            severityLevel = "severity_level",
            severityLevelDescription = "severity_level_description"
    )
}
