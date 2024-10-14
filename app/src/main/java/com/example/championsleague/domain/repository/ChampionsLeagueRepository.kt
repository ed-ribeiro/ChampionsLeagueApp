package com.example.championsleague.domain.repository

import com.example.championsleague.data.remote.dto.team_detail.TeamDetailDto
import com.example.championsleague.data.remote.dto.team_list.TeamListDto

interface ChampionsLeagueRepository {

    suspend fun getTeamList(): TeamListDto
    suspend fun getTeamById(teamId: String): TeamDetailDto
}