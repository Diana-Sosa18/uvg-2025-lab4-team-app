package com.uvg.teamapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.model.TeamMember
import com.uvg.teamapp.repository.FakeTeamRepository

@Composable
fun TeamListScreen(onItemClick: (TeamMember) -> Unit) {
    val teamMembers = FakeTeamRepository().getTeamMembers()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(teamMembers) { member ->
            TeamListItem(member = member, onClick = { onItemClick(member) })
        }
    }
}

@Composable
fun TeamListItem(member: TeamMember, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = member.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = member.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
