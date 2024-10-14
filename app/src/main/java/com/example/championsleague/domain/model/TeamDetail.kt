package com.example.championsleague.domain.model

import com.example.championsleague.data.remote.dto.team_detail.RunningCompetition

data class TeamDetail(
    val id: Int,
    val fullName: String,
    val shortName: String,
    val crest: String,
    val venue: String,
    val area: String,
    val areaFlag: String?,
    val founded: String,
    val coach: String,
    val runningCompetitions: List<RunningCompetition>
)
