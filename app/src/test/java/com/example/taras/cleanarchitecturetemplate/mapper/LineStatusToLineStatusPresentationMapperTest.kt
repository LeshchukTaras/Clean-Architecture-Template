package com.example.taras.cleanarchitecturetemplate.mapper

import com.example.taras.cleanarchitecturetemplate.data.getExpectedLineStatusPresentation
import com.example.taras.cleanarchitecturetemplate.data.getLineStatus
import com.example.taras.cleanarchitecturetemplate.utils.LineStatusToLineStatusPresentationMapper
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class LineStatusToLineStatusPresentationMapperTest {

    private val mapper = LineStatusToLineStatusPresentationMapper()

    @Test
    fun shouldMapLineStatusModelToLineStatus() {
        // given
        val lineStatus = getLineStatus()
        val expectedLineStatusPresentation = getExpectedLineStatusPresentation()

        // when
        val mappingResult = mapper.map(lineStatus)

        // then
        SoftAssertions().apply {
            assertThat(mappingResult.id)
                    .isEqualTo(expectedLineStatusPresentation.id)
            assertThat(mappingResult.name)
                    .isEqualTo(expectedLineStatusPresentation.name)
            assertThat(mappingResult.severityLevel)
                    .isEqualTo(expectedLineStatusPresentation.severityLevel)
            assertThat(mappingResult.severityLevelDescription)
                    .isEqualTo(expectedLineStatusPresentation.severityLevelDescription)
            assertThat(mappingResult.colourResourceId)
                    .isEqualTo(expectedLineStatusPresentation.colourResourceId)
            assertThat(mappingResult.badgeResourceId)
                    .isEqualTo(expectedLineStatusPresentation.badgeResourceId)
        }.assertAll()
    }
}