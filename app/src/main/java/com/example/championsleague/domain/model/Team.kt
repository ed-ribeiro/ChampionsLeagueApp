package com.example.championsleague.domain.model

data class Team(
    val id: Int,
    val position: String,
    val crest: String,
    val shortName: String,
    val won: String,
    val draw: String,
    val lost: String,
    val points: String
)
