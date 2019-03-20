package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.Sets
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName
import me.fzzy.fzzytourney.util.SmashGGApi

object Losers {

    fun init() {
        val player1 = ObsField(80.0, 325.0, TourneyApp.bracketNameSize, "Losers 1")
        val player1Wins = ObsField(285.0, 325.0, TourneyApp.bracketWinsSize, "Losers 1 Wins").setWinsValue()
        val player2 = ObsField(80.0, 367.0, TourneyApp.bracketNameSize, "Losers 2")
        val player2Wins = ObsField(285.0, 367.0, TourneyApp.bracketWinsSize, "Losers 2 Wins").setWinsValue()

        val identifier1 = ObsField(326.0, 346.0, TourneyApp.bracketWinsSize, "Losers Identifier 1").onlyUppercase()

        Sets.addSet(Sets.TourneySet(player1, player1Wins, player2, player2Wins, identifier1))

        val player3 = ObsField(80.0, 433.0, TourneyApp.bracketNameSize, "Losers 3")
        val player3Wins = ObsField(285.0, 433.0, TourneyApp.bracketWinsSize, "Losers 3 Wins").setWinsValue()
        val player4 = ObsField(80.0, 474.0, TourneyApp.bracketNameSize, "Losers 4")
        val player4Wins = ObsField(285.0, 474.0, TourneyApp.bracketWinsSize, "Losers 4 Wins").setWinsValue()

        val identifier2 = ObsField(326.0, 453.0, TourneyApp.bracketWinsSize, "Losers Identifier 2").onlyUppercase()

        Sets.addSet(Sets.TourneySet(player3, player3Wins, player4, player4Wins, identifier2))

        val player5 = ObsField(430.0, 325.0, TourneyApp.bracketNameSize, "Losers 5")
        val player5Wins = ObsField(635.0, 325.0, TourneyApp.bracketWinsSize, "Losers 5 Wins").setWinsValue()
        val player6 = ObsField(430.0, 367.0, TourneyApp.bracketNameSize, "Losers 6")
        val player6Wins = ObsField(635.0, 367.0, TourneyApp.bracketWinsSize, "Losers 6 Wins").setWinsValue()

        val identifier3 = ObsField(676.0, 346.0, TourneyApp.bracketWinsSize, "Losers Identifier 3").onlyUppercase()

        Sets.addSet(Sets.TourneySet(player5, player5Wins, player6, player6Wins, identifier3))

        val player7 = ObsField(430.0, 433.0, TourneyApp.bracketNameSize, "Losers 7")
        val player7Wins = ObsField(635.0, 433.0, TourneyApp.bracketWinsSize, "Losers 7 Wins").setWinsValue()
        val player8 = ObsField(430.0, 474.0, TourneyApp.bracketNameSize, "Losers 8")
        val player8Wins = ObsField(635.0, 474.0, TourneyApp.bracketWinsSize, "Losers 8 Wins").setWinsValue()

        val identifier4 = ObsField(676.0, 453.0, TourneyApp.bracketWinsSize, "Losers Identifier 4").onlyUppercase()

        Sets.addSet(Sets.TourneySet(player7, player7Wins, player8, player8Wins, identifier4))
    }

}