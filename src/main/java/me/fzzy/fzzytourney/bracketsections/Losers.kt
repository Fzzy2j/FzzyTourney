package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object Losers {

    val names = arrayListOf<PlayerValues>()
    val wins = arrayListOf<PlayerValues>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    val player3 get() = names[2]
    val player3Wins get() = wins[2]

    val player4 get() = names[3]
    val player4Wins get() = wins[3]

    val player5 get() = names[4]
    val player5Wins get() = wins[4]

    val player6 get() = names[5]
    val player6Wins get() = wins[5]

    val player7 get() = names[6]
    val player7Wins get() = wins[6]

    val player8 get() = names[7]
    val player8Wins get() = wins[7]

    init {
        names.add(PlayerValues(80.0, 325.0, TourneyApp.bracketNameSize, "Losers 1"))
        wins.add(PlayerValues(285.0, 325.0, TourneyApp.bracketWinsSize, "Losers 1 Wins").wins())

        names.add(PlayerValues(80.0, 367.0, TourneyApp.bracketNameSize, "Losers 2"))
        wins.add(PlayerValues(285.0, 367.0, TourneyApp.bracketWinsSize, "Losers 2 Wins").wins())

        names.add(PlayerValues(80.0, 433.0, TourneyApp.bracketNameSize, "Losers 3"))
        wins.add(PlayerValues(285.0, 433.0, TourneyApp.bracketWinsSize, "Losers 3 Wins").wins())

        names.add(PlayerValues(80.0, 474.0, TourneyApp.bracketNameSize, "Losers 4"))
        wins.add(PlayerValues(285.0, 474.0, TourneyApp.bracketWinsSize, "Losers 4 Wins").wins())

        names.add(PlayerValues(430.0, 325.0, TourneyApp.bracketNameSize, "Losers 5"))
        wins.add(PlayerValues(635.0, 325.0, TourneyApp.bracketWinsSize, "Losers 5 Wins").wins())

        names.add(PlayerValues(430.0, 367.0, TourneyApp.bracketNameSize, "Losers 6"))
        wins.add(PlayerValues(635.0, 367.0, TourneyApp.bracketWinsSize, "Losers 6 Wins").wins())

        names.add(PlayerValues(430.0, 433.0, TourneyApp.bracketNameSize, "Losers 7"))
        wins.add(PlayerValues(635.0, 433.0, TourneyApp.bracketWinsSize, "Losers 7 Wins").wins())

        names.add(PlayerValues(430.0, 474.0, TourneyApp.bracketNameSize, "Losers 8"))
        wins.add(PlayerValues(635.0, 474.0, TourneyApp.bracketWinsSize, "Losers 8 Wins").wins())
    }

}