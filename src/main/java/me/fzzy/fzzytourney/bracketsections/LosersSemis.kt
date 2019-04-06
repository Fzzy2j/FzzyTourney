package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.Sets
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName

object LosersSemis {

    fun init() {
        val player1 = ObsField(780.0, 379.0, TourneyApp.bracketNameSize, "Losers Semis 1")
        val player1Wins = ObsField(985.0, 379.0, TourneyApp.bracketWinsSize, "Losers Semis 1 Wins").setWinsValue()
        val player2 = ObsField(780.0, 420.0, TourneyApp.bracketNameSize, "Losers Semis 2")
        val player2Wins = ObsField(985.0, 420.0, TourneyApp.bracketWinsSize, "Losers Semis 2 Wins").setWinsValue()

        Sets.addSet(Sets.TourneySet(player1, player1Wins, player2, player2Wins))
    }

}