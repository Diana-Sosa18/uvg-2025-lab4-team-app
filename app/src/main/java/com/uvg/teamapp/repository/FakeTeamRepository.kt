package com.uvg.teamapp.repository

import com.uvg.teamapp.model.TeamMember

class FakeTeamRepository {
    fun getTeamMembers(): List<TeamMember> {
        return listOf(
            TeamMember("Diana", "Me gusta mucho dar paseos en área naturales, como en bosques o jardines y también me gusta mucho cocinar postres."),
            TeamMember("René", "Comandante de los ejércitos del Norte, general de las legiones medias."),
            TeamMember("Biancka", "Me gusta mucho leer y escuchar música.")
        )
    }
}