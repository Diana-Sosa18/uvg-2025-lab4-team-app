package com.uvg.teamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.teamapp.model.TeamMember
import com.uvg.teamapp.repository.FakeTeamRepository
import com.uvg.teamapp.ui.TeamDetailScreen//cambio de módulo
import com.uvg.teamapp.ui.TeamListScreen
import com.uvg.teamapp.ui.theme.TeamAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeamAppTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "teamList",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("teamList") {
                            TeamListScreen(
                                onItemClick = { teamMember ->
                                    navController.navigate("teamDetail/${teamMember.name}")
                                }
                            )
                        }
                        composable("teamDetail/{name}") { backStackEntry ->
                            val memberName = backStackEntry.arguments?.getString("name")
                            val member = FakeTeamRepository().getTeamMembers().find { it.name == memberName }
                            member?.let {
                                TeamDetailScreen(member = it)
                            }
                        }
                    }
                }
            }
        }
    }
}
