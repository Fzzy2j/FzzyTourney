package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.Sets
import me.fzzy.fzzytourney.TourneyApp

object GrandFinals {

    fun init() {
        val player1 = ObsField(780.0, 134.0, TourneyApp.bracketNameSize, "Grand Finals 1")
        val player1Wins = ObsField(985.0, 134.0, TourneyApp.bracketWinsSize, "Grand Finals 1 Wins").setWinsValue()
        val player2 = ObsField(780.0, 175.0, TourneyApp.bracketNameSize, "Grand Finals 2")
        val player2Wins = ObsField(985.0, 175.0, TourneyApp.bracketWinsSize, "Grand Finals 2 Wins").setWinsValue()

        val identifier = ObsField(1026.0, 154.0, TourneyApp.bracketWinsSize, "Grand Finals Identifier").onlyUppercase()

        Sets.addSet(Sets.TourneySet(player1, player1Wins, player2, player2Wins, identifier))
    }

}