package com.uvg.teamapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.model.TeamMember

@Composable
fun TeamDetailScreen(member: TeamMember) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = member.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = member.description)
    }
}
