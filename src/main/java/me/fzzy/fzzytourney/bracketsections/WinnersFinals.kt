package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.Sets
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName
import me.fzzy.fzzytourney.util.SmashGGApi

object WinnersFinals {

    fun init() {
        val player1 = ObsField(430.0, 134.0, TourneyApp.bracketNameSize, "Winners Finals 1")
        val player1Wins = ObsField(635.0, 134.0, TourneyApp.bracketWinsSize, "Winners Finals 1 Wins").setWinsValue()
        val player2 = ObsField(430.0, 175.0, TourneyApp.bracketNameSize, "Winners Finals 2")
        val player2Wins = ObsField(635.0, 175.0, TourneyApp.bracketWinsSize, "Winners Finals 2 Wins").setWinsValue()

        val identifier = ObsField(676.0, 154.0, TourneyApp.bracketWinsSize, "Winers Finals Identifier").onlyUppercase()

        Sets.addSet(Sets.TourneySet(player1, player1Wins, player2, player2Wins, identifier))
    }

}