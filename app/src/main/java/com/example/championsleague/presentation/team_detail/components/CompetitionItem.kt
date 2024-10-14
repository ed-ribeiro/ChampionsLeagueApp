package com.example.championsleague.presentation.team_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.championsleague.R
import com.example.championsleague.data.remote.dto.team_detail.RunningCompetition

@Composable
fun CompetitionItem(
    runningCompetition: RunningCompetition,
) {
    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = runningCompetition.emblem,
                error = painterResource(id = R.drawable.competition_placeholder),
                contentDescription = "${runningCompetition.name}'s emblem",
                modifier = Modifier
                    .size(80.dp),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = runningCompetition.name,
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Preview
@Composable
fun CompetitionItemPreview() {
    CompetitionItem(
        RunningCompetition(
            code = "",
            emblem = "",
            name = "Primeira Liga",
            id = 1,
            type = ""
        )
    )
}