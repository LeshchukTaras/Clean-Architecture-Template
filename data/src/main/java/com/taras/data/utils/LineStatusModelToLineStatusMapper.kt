package com.taras.data.utils

import com.taras.data.network.model.LineStatusModel
import com.taras.domain.mapper.Mapper
import com.taras.domain.model.LineStatus

class LineStatusModelToLineStatusMapper : Mapper<LineStatusModel, LineStatus> {

    override fun map(from: LineStatusModel): LineStatus {
        return LineStatus(
                id = from.id,
                name = from.name,
                severityLevel = from.statuses[0].severityLevel,
                severityLevelDescription = from.statuses[0].severityLevelDescription
        )
    }
}
