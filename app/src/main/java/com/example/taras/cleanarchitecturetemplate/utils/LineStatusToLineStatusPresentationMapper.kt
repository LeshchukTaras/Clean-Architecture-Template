package com.example.taras.cleanarchitecturetemplate.utils

import com.example.taras.cleanarchitecturetemplate.R
import com.example.taras.cleanarchitecturetemplate.model.LineStatusPresentation
import com.taras.domain.mapper.Mapper
import com.taras.domain.model.LineStatus

class LineStatusToLineStatusPresentationMapper: Mapper<LineStatus, LineStatusPresentation> {

    override fun map(from: LineStatus): LineStatusPresentation {
        return LineStatusPresentation(
                id = from.id,
                name = from.name,
                severityLevel = from.severityLevel,
                severityLevelDescription = from.severityLevelDescription,
                colourResourceId = generateColourResourceId(from.severityLevel),
                badgeResourceId = mapLineBadge(from.id)
        )
    }

    private fun generateColourResourceId(severityLevel: String): Int =
            when(severityLevel) {
                "good" -> R.color.colorGreen
                "minor" -> R.color.colorOrange
                "severe" -> R.color.colorRed
                else -> R.color.colorLightGrey
            }

    private fun mapLineBadge(lineId: String): Int =
            when (lineId) {
                "central" -> R.drawable.ic_central
                "piccadilly" -> R.drawable.ic_piccadilly
                "victoria" -> R.drawable.ic_victoria
                "northern" -> R.drawable.ic_northern
                "district" -> R.drawable.ic_district
                "circle" -> R.drawable.ic_circle
                "hammersmith-city" -> R.drawable.ic_hammersmith
                "metropolitan" -> R.drawable.ic_metropolitan
                "bakerloo" -> R.drawable.ic_bakerloo
                "waterloo-city" -> R.drawable.ic_waterloo
                "jubilee" -> R.drawable.ic_jubilee
                "overground" -> R.drawable.ic_overground
                else -> R.drawable.ic_tube
            }

}