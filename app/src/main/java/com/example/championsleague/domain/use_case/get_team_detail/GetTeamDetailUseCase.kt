package com.example.championsleague.domain.use_case.get_team_detail

import com.example.championsleague.common.Resource
import com.example.championsleague.data.remote.dto.team_detail.toTeamDetail
import com.example.championsleague.domain.model.TeamDetail
import com.example.championsleague.domain.repository.ChampionsLeagueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamDetailUseCase @Inject constructor(
    private val repository: ChampionsLeagueRepository
) {
    operator fun invoke(teamId: String): Flow<Resource<TeamDetail>> = flow {
        try {
            emit(Resource.Loading())
            val team = repository.getTeamById(teamId).toTeamDetail()
            emit(Resource.Success(team))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Error connecting to the server, please check your internet connection."))
        }
    }
}