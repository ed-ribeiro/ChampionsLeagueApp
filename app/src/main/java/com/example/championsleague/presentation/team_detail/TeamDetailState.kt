package com.example.championsleague.presentation.team_detail

import com.example.championsleague.domain.model.TeamDetail

data class TeamDetailState(
    val isLoading: Boolean = false,
    val team: TeamDetail? = null,
    val error: String = ""
)