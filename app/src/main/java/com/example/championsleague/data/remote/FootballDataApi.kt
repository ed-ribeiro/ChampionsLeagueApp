package com.example.championsleague.data.remote

import com.example.championsleague.common.Constants
import com.example.championsleague.data.remote.dto.team_detail.TeamDetailDto
import com.example.championsleague.data.remote.dto.team_list.TeamListDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FootballDataApi {

    @Headers("X-Auth-Token: " + Constants.API_KEY)
    @GET("competitions/CL/standings")
    suspend fun getTeamList(): TeamListDto

    @Headers("X-Auth-Token: " + Constants.API_KEY)
    @GET("teams/{teamId}")
    suspend fun getTeamById(@Path("teamId") teamId: String): TeamDetailDto
}