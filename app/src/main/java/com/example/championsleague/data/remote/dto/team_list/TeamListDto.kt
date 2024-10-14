package com.example.championsleague.data.remote.dto.team_list

data class TeamListDto(
    val area: Area,
    val competition: Competition,
    val filters: Filters,
    val season: Season,
    val standings: List<CompetitionStage>
)