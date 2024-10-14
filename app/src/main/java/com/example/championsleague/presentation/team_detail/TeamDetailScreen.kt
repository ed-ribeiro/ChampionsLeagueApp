package com.example.championsleague.presentation.team_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import com.example.championsleague.presentation.team_detail.components.CompetitionItem
import com.example.championsleague.presentation.team_detail.components.InformationItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreen(
    navController: NavController,
    viewModel: TeamDetailViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val state = viewModel.state.value

        state.team?.let { team ->
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(text = "Team Details")
                        },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Go back"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior
                    )
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    model = team.crest,
                                    contentDescription = "${team.shortName} crest",
                                    modifier = Modifier
                                        .size(128.dp),
                                    contentScale = ContentScale.Fit,
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = team.shortName,
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Row {
                                    if (team.areaFlag != null) {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(team.areaFlag)
                                                .decoderFactory(SvgDecoder.Factory())
                                                .build(),
                                            contentDescription = "${team.shortName} crest",
                                            modifier = Modifier
                                                .size(24.dp),
                                            contentScale = ContentScale.Fit,
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = team.area)
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Information",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        item {
                            InformationItem(title = "Full Name", description = team.fullName)
                        }
                        item {
                            InformationItem(title = "Stadium", description = team.venue)
                        }
                        item {
                            InformationItem(title = "Founded", description = team.founded)
                        }
                        item {
                            InformationItem(title = "Coach", description = team.coach)
                        }
                        item {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Running Competitions",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(team.runningCompetitions) { runningCompetition ->
                                    CompetitionItem(runningCompetition)
                                }
                            }
                        }
                    }
                }
            }
        }
        if (state.error.isNotBlank()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { viewModel.getTeamAgain() }) {
                    Text(text = "Try Again", color = MaterialTheme.colorScheme.onError)
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}