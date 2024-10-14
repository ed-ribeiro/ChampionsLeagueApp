package com.example.championsleague.data.remote.dto.team_list

data class CompetitionStage(
    val stage: String,
    val table: List<TeamTableStats>,
)