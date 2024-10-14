package com.example.championsleague.presentation.team_list

import com.example.championsleague.domain.model.Team

data class TeamListState(
    val isLoading: Boolean = false,
    val teams: List<Team> = emptyList(),
    val error: String = ""
)
