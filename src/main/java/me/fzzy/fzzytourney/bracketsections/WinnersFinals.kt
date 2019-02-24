package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object WinnersFinals {

    val names = arrayListOf<PlayerValues>()
    val wins = arrayListOf<PlayerValues>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    init {
        names.add(PlayerValues(430.0, 134.0, TourneyApp.bracketNameSize, "Winners Finals 1"))
        wins.add(PlayerValues(635.0, 134.0, TourneyApp.bracketWinsSize, "Winners Finals 1 Wins").wins())

        names.add(PlayerValues(430.0, 175.0, TourneyApp.bracketNameSize, "Winners Finals 2"))
        wins.add(PlayerValues(635.0, 175.0, TourneyApp.bracketWinsSize, "Winners Finals 2 Wins").wins())
    }

}