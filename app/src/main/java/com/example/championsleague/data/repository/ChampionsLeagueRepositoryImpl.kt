package com.example.championsleague.data.repository

import com.example.championsleague.data.remote.FootballDataApi
import com.example.championsleague.data.remote.dto.team_detail.TeamDetailDto
import com.example.championsleague.data.remote.dto.team_list.TeamListDto
import com.example.championsleague.domain.repository.ChampionsLeagueRepository
import javax.inject.Inject


class ChampionsLeagueRepositoryImpl @Inject constructor(
    private val api: FootballDataApi
) : ChampionsLeagueRepository {

    override suspend fun getTeamList(): TeamListDto {
        return api.getTeamList()
    }

    override suspend fun getTeamById(teamId: String): TeamDetailDto {
        return api.getTeamById(teamId)
    }
}