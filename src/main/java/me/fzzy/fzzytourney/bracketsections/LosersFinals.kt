package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object LosersFinals {

    val names = arrayListOf<PlayerValues>()
    val wins = arrayListOf<PlayerValues>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    init {
        names.add(PlayerValues(1130.0, 325.0, TourneyApp.bracketNameSize, "Losers Finals 5"))
        wins.add(PlayerValues(1335.0, 325.0, TourneyApp.bracketWinsSize, "Losers Finals 5 Wins").wins())

        names.add(PlayerValues(1130.0, 367.0, TourneyApp.bracketNameSize, "Losers Finals 6"))
        wins.add(PlayerValues(1335.0, 367.0, TourneyApp.bracketWinsSize, "Losers Finals 6 Wins").wins())
    }

}