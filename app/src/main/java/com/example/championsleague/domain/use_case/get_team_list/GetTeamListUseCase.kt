package com.example.championsleague.domain.use_case.get_team_list

import com.example.championsleague.common.Resource
import com.example.championsleague.data.remote.dto.team_list.toTeam
import com.example.championsleague.domain.model.Team
import com.example.championsleague.domain.repository.ChampionsLeagueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamListUseCase @Inject constructor(
    private val repository: ChampionsLeagueRepository
) {
    operator fun invoke(): Flow<Resource<List<Team>>> = flow {
        try {
            emit(Resource.Loading())
            val teamTableStats = repository.getTeamList().standings.map { it.table }.flatten()
            val teams = teamTableStats.map { it.toTeam() }
            emit(Resource.Success(teams))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Error connecting to the server, please check your internet connection."))
        }
    }
}