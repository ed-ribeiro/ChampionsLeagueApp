package com.example.championsleague.presentation.team_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleague.common.Constants
import com.example.championsleague.common.Resource
import com.example.championsleague.domain.use_case.get_team_detail.GetTeamDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val getTeamDetailUseCase: GetTeamDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(TeamDetailState())
    val state: State<TeamDetailState> = _state
    private lateinit var _teamId: String

    init {
        savedStateHandle.get<String>(Constants.PARAM_TEAM_ID)?.let { teamId ->
            _teamId = teamId
            getTeam(teamId)
        }
    }

    private fun getTeam(teamId: String) {
        getTeamDetailUseCase(teamId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TeamDetailState(team = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        TeamDetailState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = TeamDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getTeamAgain() {
        getTeam(_teamId)
    }
}