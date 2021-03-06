package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.Sets
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName

object LosersFinals {

    fun init() {
        val player1 = ObsField(1130.0, 325.0, TourneyApp.bracketNameSize, "Losers Finals 1")
        val player1Wins = ObsField(1335.0, 325.0, TourneyApp.bracketWinsSize, "Losers Finals 1 Wins").setWinsValue()
        val player2 = ObsField(1130.0, 367.0, TourneyApp.bracketNameSize, "Losers Finals 2")
        val player2Wins = ObsField(1335.0, 367.0, TourneyApp.bracketWinsSize, "Losers Finals 2 Wins").setWinsValue()

        Sets.addSet(Sets.TourneySet("Losers Finals", player1, player1Wins, player2, player2Wins))
    }

}