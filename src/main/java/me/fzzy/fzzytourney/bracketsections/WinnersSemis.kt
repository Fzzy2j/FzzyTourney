package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.Sets
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName

object WinnersSemis {

    fun init() {
        val player1 = ObsField(80.0, 78.0, TourneyApp.bracketNameSize, "Winners Semis 1")
        val player1Wins = ObsField(285.0, 78.0, TourneyApp.bracketWinsSize, "Winners Semis 1 Wins").setWinsValue()
        val player2 = ObsField(80.0, 119.0, TourneyApp.bracketNameSize, "Winners Semis 2")
        val player2Wins = ObsField(285.0, 119.0, TourneyApp.bracketWinsSize, "Winners Semis 2 Wins").setWinsValue()

        Sets.addSet(Sets.TourneySet("Winners Semis", player1, player1Wins, player2, player2Wins))

        val player3 = ObsField(80.0, 187.0, TourneyApp.bracketNameSize, "Winners Semis 3")
        val player3Wins = ObsField(285.0, 187.0, TourneyApp.bracketWinsSize, "Winners Semis 3 Wins").setWinsValue()
        val player4 = ObsField(80.0, 228.0, TourneyApp.bracketNameSize, "Winners Semis 4")
        val player4Wins = ObsField(285.0, 228.0, TourneyApp.bracketWinsSize, "Winners Semis 4 Wins").setWinsValue()

        Sets.addSet(Sets.TourneySet("Winners Semis", player3, player3Wins, player4, player4Wins))
    }

}