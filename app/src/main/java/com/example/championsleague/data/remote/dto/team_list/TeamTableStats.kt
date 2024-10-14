package com.example.championsleague.data.remote.dto.team_list

import com.example.championsleague.domain.model.Team

data class TeamTableStats(
    val draw: Int,
    val form: Any,
    val goalDifference: Int,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val lost: Int,
    val playedGames: Int,
    val points: Int,
    val position: Int,
    val team: TeamInfo,
    val won: Int
)

fun TeamTableStats.toTeam(): Team {
    return Team(
        id = team.id,
        position = position.toString(),
        crest = team.crest,
        shortName = team.shortName,
        won = won.toString(),
        draw = draw.toString(),
        lost = lost.toString(),
        points = points.toString()
    )
}