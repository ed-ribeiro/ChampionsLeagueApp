package com.example.championsleague.data.remote.dto.team_detail

import com.example.championsleague.domain.model.TeamDetail

data class TeamDetailDto(
    val address: String,
    val area: Area,
    val clubColors: Any,
    val coach: Coach,
    val crest: String,
    val founded: Int,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val runningCompetitions: List<RunningCompetition>,
    val shortName: String,
    val squad: List<Squad>,
    val staff: List<Any>,
    val tla: String,
    val venue: String,
    val website: String
)

fun TeamDetailDto.toTeamDetail(): TeamDetail {
    return TeamDetail(
        id = id,
        fullName = name,
        crest = crest,
        venue = venue,
        area = area.name,
        areaFlag = area.flag,
        coach = coach.name,
        founded = founded.toString(),
        shortName = shortName,
        runningCompetitions = runningCompetitions
    )
}