package com.example.championsleague.presentation

sealed class Screen(val route: String) {
    data object TeamListScreen : Screen("team_list_screen")
    data object TeamDetailScreen : Screen("team_detail_screen")
}