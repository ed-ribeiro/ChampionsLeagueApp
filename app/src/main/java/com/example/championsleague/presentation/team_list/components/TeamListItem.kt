package com.example.championsleague.presentation.team_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.championsleague.domain.model.Team

@Composable
fun TeamListItem(
    team: Team,
    onItemClick: (Team) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(team) }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.width(24.dp),
                text = team.position,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(8.dp))
            AsyncImage(
                model = team.crest,
                contentDescription = "${team.shortName} crest",
                modifier = Modifier
                    .size(28.dp),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = team.shortName
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                space = 22.dp,
                alignment = Alignment.End
            )
        ) {
            Text(
                text = team.won
            )
            Text(
                text = team.draw
            )
            Text(
                text = team.lost
            )
            Text(
                text = team.points,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun TeamListItemPreview() {
    TeamListItem(
        team = Team(
            id = 1,
            position = "3",
            crest = "",
            shortName = "SL Benfica",
            won = "2",
            draw = "0",
            lost = "0",
            points = "6"
        ),
        onItemClick = {}
    )
}
