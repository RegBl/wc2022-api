package dev.mfazio.wc2022.types.api

import dev.mfazio.wc2022.types.ScheduledMatch
import kotlinx.serialization.Serializable

@Serializable
data class ScheduledMatchApiModel(
    val homeTeam: String,
    val awayTeam: String,
    val dateTime: String,
    val group: String,
    val location: String,
    val stadium: String,
    val matchStatus: MatchStatusApiModel,
    val homeScore: Int? = null,
    val awayScore: Int? = null,
    val currentMinute: Int? = null,
) {
    companion object {
        fun fromScheduledMatch(scheduledMatch: ScheduledMatch) = ScheduledMatchApiModel(
            homeTeam = scheduledMatch.homeTeam,
            awayTeam = scheduledMatch.awayTeam,
            dateTime = scheduledMatch.dateTime,
            group = scheduledMatch.group,
            location = scheduledMatch.location,
            stadium = scheduledMatch.stadium,
            matchStatus = MatchStatusApiModel.fromMatchStatus(scheduledMatch.matchStatus),
            homeScore = scheduledMatch.homeScore,
            awayScore = scheduledMatch.awayScore,
        )
    }
}
