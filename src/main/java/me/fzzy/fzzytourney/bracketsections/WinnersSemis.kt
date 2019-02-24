package me.fzzy.fzzytourney.bracketsections

import javafx.scene.layout.Pane
import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object WinnersSemis {

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

    init {
        names.add(PlayerValues(80.0, 78.0, TourneyApp.bracketNameSize, "Winners Semis 1"))
        wins.add(PlayerValues(285.0, 78.0, TourneyApp.bracketWinsSize, "Winners Semis 1 Wins").wins())

        names.add(PlayerValues(80.0, 119.0, TourneyApp.bracketNameSize, "Winners Semis 2"))
        wins.add(PlayerValues(285.0, 119.0, TourneyApp.bracketWinsSize, "Winners Semis 2 Wins").wins())

        names.add(PlayerValues(80.0, 187.0, TourneyApp.bracketNameSize, "Winners Semis 3"))
        wins.add(PlayerValues(285.0, 187.0, TourneyApp.bracketWinsSize, "Winners Semis 3 Wins").wins())

        names.add(PlayerValues(80.0, 228.0, TourneyApp.bracketNameSize, "Winners Semis 4"))
        wins.add(PlayerValues(285.0, 228.0, TourneyApp.bracketWinsSize, "Winners Semis 4 Wins").wins())
    }

}