package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object LosersSemis {

    val names = arrayListOf<PlayerValues>()
    val wins = arrayListOf<PlayerValues>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    init {
        names.add(PlayerValues(780.0, 379.0, TourneyApp.bracketNameSize, "Losers Semis 1"))
        wins.add(PlayerValues(985.0, 379.0, TourneyApp.bracketWinsSize, "Losers Semis 1 Wins").wins())

        names.add(PlayerValues(780.0, 420.0, TourneyApp.bracketNameSize, "Losers Semis 2"))
        wins.add(PlayerValues(985.0, 420.0, TourneyApp.bracketWinsSize, "Losers Semis 2 Wins").wins())
    }

}