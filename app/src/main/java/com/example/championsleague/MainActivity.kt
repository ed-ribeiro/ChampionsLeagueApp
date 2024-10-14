package com.example.championsleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.championsleague.presentation.Screen
import com.example.championsleague.presentation.team_detail.TeamDetailScreen
import com.example.championsleague.presentation.team_list.TeamListScreen
import com.example.championsleague.presentation.ui.theme.ChampionsLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChampionsLeagueTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TeamListScreen.route
                    ) {
                        composable(
                            route = Screen.TeamListScreen.route
                        ) {
                            TeamListScreen(navController)
                        }
                        composable(
                            route = Screen.TeamDetailScreen.route + "/{teamId}"
                        ) {
                            TeamDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChampionsLeagueTheme {
        Greeting("Android")
    }
}