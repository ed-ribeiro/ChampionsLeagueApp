package com.example.championsleague.presentation.team_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleague.common.Resource
import com.example.championsleague.domain.use_case.get_team_list.GetTeamListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TeamListState())
    val state: State<TeamListState> = _state

    init {
        getTeams()
    }

    fun getTeams() {
        getTeamListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TeamListState(teams = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        TeamListState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = TeamListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}