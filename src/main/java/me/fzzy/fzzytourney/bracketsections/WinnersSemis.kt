package me.fzzy.fzzytourney.bracketsections

import javafx.scene.layout.Pane
import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object WinnersSemis {

    private val values = hashMapOf<String, PlayerValues>()

    val player1 get() = values["Winners Semis 1"]!!
    val player1Wins get() = values["Winners Semis 1 Wins"]!!

    val player2 get() = values["Winners Semis 2"]!!
    val player2Wins get() = values["Winners Semis 2 Wins"]!!

    val player3 get() = values["Winners Semis 3"]!!
    val player3Wins get() = values["Winners Semis 3 Wins"]!!

    val player4 get() = values["Winners Semis 4"]!!
    val player4Wins get() = values["Winners Semis 4 Wins"]!!

    val all get() = values.values

    init {
        values["Winners Semis 1"] = PlayerValues(80.0, 78.0, TourneyApp.bracketNameSize, "Winners Semis 1")
        values["Winners Semis 1 Wins"] = PlayerValues(285.0, 78.0, TourneyApp.bracketWinsSize, "Winners Semis 1 Wins").black()

        values["Winners Semis 2"] = PlayerValues(80.0, 119.0, TourneyApp.bracketNameSize, "Winners Semis 2")
        values["Winners Semis 2 Wins"] = PlayerValues(285.0, 119.0, TourneyApp.bracketWinsSize, "Winners Semis 2 Wins").black()

        values["Winners Semis 3"] = PlayerValues(80.0, 187.0, TourneyApp.bracketNameSize, "Winners Semis 3")
        values["Winners Semis 3 Wins"] = PlayerValues(285.0, 187.0, TourneyApp.bracketWinsSize, "Winners Semis 3 Wins").black()

        values["Winners Semis 4"] = PlayerValues(80.0, 228.0, TourneyApp.bracketNameSize, "Winners Semis 4")
        values["Winners Semis 4 Wins"] = PlayerValues(285.0, 228.0, TourneyApp.bracketWinsSize, "Winners Semis 4 Wins").black()
    }

}