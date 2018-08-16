package com.taras.data

import com.taras.data.utils.LineStatusModelToLineStatusMapper
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class LineStatusModelToLineStatusMapperTest {

    private val mapper = LineStatusModelToLineStatusMapper()

    @Test
    fun shouldMapLineStatusModelToStatus() {
        val lineStatusModel = getLineStatusModel()
        val expectedLineStatus = getExpectedLineStatus()

        val mappingResult = mapper.map(lineStatusModel)

        SoftAssertions().apply {
            assertThat(mappingResult.id).isEqualTo(expectedLineStatus.id)
            assertThat(mappingResult.name).isEqualTo(expectedLineStatus.name)
            assertThat(mappingResult.severityLevel).isEqualTo(expectedLineStatus.severityLevel)
            assertThat(mappingResult.severityLevelDescription).isEqualTo(expectedLineStatus.severityLevelDescription)
        }.assertAll()
    }
}