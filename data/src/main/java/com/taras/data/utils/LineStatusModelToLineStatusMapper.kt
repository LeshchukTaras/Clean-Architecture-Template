package com.taras.data.utils

import com.taras.data.network.model.LineStatusModel
import com.taras.domain.mapper.Mapper
import com.taras.domain.model.LineStatus

class LineStatusModelToLineStatusMapper : Mapper<LineStatusModel, LineStatus> {

    override fun map(from: LineStatusModel): LineStatus {
        return LineStatus(
                id = from.id,
                name = from.name,
                severityLevel = mapSeverityLevel(from.statuses[0].severityLevel),
                severityLevelDescription = from.statuses[0].severityLevelDescription
        )
    }

    private fun mapSeverityLevel(severityLevel: Int): String =
            when (severityLevel) {
                10, 18, 19 -> "good"
                0, 4, 5, 9, 11, 12, 13, 14, 17 -> "minor"
                1, 2, 3, 6, 7, 8, 15, 16, 20 -> "severe"
                else -> "default"
            }
}
