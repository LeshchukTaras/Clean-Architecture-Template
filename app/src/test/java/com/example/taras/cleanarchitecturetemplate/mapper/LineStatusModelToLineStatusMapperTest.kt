package com.example.taras.cleanarchitecturetemplate.mapper

import com.example.taras.cleanarchitecturetemplate.data.getExpectedLineStatus
import com.example.taras.cleanarchitecturetemplate.data.getLineStatusModel
import com.taras.data.utils.LineStatusModelToLineStatusMapper
import org.junit.Test
import org.assertj.core.api.SoftAssertions

class LineStatusModelToLineStatusMapperTest {

    private val mapper = LineStatusModelToLineStatusMapper()

    @Test
    fun shouldMapLineStatusModelToStatus() {
        // given
        val lineStatusModel = getLineStatusModel()
        val expectedLineStatus = getExpectedLineStatus()

        // when
        val mappingResult = mapper.map(lineStatusModel)

        // then
        SoftAssertions().apply {
            assertThat(mappingResult.id).isEqualTo(expectedLineStatus.id)
            assertThat(mappingResult.name).isEqualTo(expectedLineStatus.name)
            assertThat(mappingResult.severityLevel).isEqualTo(expectedLineStatus.severityLevel)
            assertThat(mappingResult.severityLevelDescription).isEqualTo(expectedLineStatus.severityLevelDescription)
        }.assertAll()
    }
}