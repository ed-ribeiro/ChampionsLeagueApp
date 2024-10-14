package com.example.championsleague.presentation.team_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TeamListLabel() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.width(24.dp),
                text = "#",
                color = MaterialTheme.colorScheme.surface,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Team",
                color = MaterialTheme.colorScheme.surface
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
                text = "W",
                color = MaterialTheme.colorScheme.surface
            )
            Text(
                text = "D",
                color = MaterialTheme.colorScheme.surface
            )
            Text(
                text = "L",
                color = MaterialTheme.colorScheme.surface
            )
            Text(
                text = "P",
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Preview
@Composable
fun TeamListLabelPreview() {
    TeamListLabel()
}
