package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.PlayerValues
import me.fzzy.fzzytourney.TourneyApp

object Losers {

    private val values = hashMapOf<String, PlayerValues>()

    val player1 get() = values["Losers 1"]!!
    val player1Wins get() = values["Losers 1 Wins"]!!

    val player2 get() = values["Losers 2"]!!
    val player2Wins get() = values["Losers 2 Wins"]!!

    val player3 get() = values["Losers 3"]!!
    val player3Wins get() = values["Losers 3 Wins"]!!

    val player4 get() = values["Losers 4"]!!
    val player4Wins get() = values["Losers 4 Wins"]!!

    val player5 get() = values["Losers 5"]!!
    val player5Wins get() = values["Losers 5 Wins"]!!

    val player6 get() = values["Losers 6"]!!
    val player6Wins get() = values["Losers 6 Wins"]!!

    val player7 get() = values["Losers 7"]!!
    val player7Wins get() = values["Losers 7 Wins"]!!

    val player8 get() = values["Losers 8"]!!
    val player8Wins get() = values["Losers 8 Wins"]!!

    val all get() = values.values

    init {
        values["Losers 1"] = PlayerValues(80.0, 325.0, TourneyApp.bracketNameSize, "Losers 1")
        values["Losers 1 Wins"] = PlayerValues(285.0, 325.0, TourneyApp.bracketWinsSize, "Losers 1 Wins").black()

        values["Losers 2"] = PlayerValues(80.0, 367.0, TourneyApp.bracketNameSize, "Losers 2")
        values["Losers 2 Wins"] = PlayerValues(285.0, 367.0, TourneyApp.bracketWinsSize, "Losers 2 Wins").black()

        values["Losers 3"] = PlayerValues(80.0, 433.0, TourneyApp.bracketNameSize, "Losers 3")
        values["Losers 3 Wins"] = PlayerValues(285.0, 433.0, TourneyApp.bracketWinsSize, "Losers 3 Wins").black()

        values["Losers 4"] = PlayerValues(80.0, 474.0, TourneyApp.bracketNameSize, "Losers 4")
        values["Losers 4 Wins"] = PlayerValues(285.0, 474.0, TourneyApp.bracketWinsSize, "Losers 4 Wins").black()

        values["Losers 5"] = PlayerValues(430.0, 325.0, TourneyApp.bracketNameSize, "Losers 5")
        values["Losers 5 Wins"] = PlayerValues(635.0, 325.0, TourneyApp.bracketWinsSize, "Losers 5 Wins").black()

        values["Losers 6"] = PlayerValues(430.0, 367.0, TourneyApp.bracketNameSize, "Losers 6")
        values["Losers 6 Wins"] = PlayerValues(635.0, 367.0, TourneyApp.bracketWinsSize, "Losers 6 Wins").black()

        values["Losers 7"] = PlayerValues(430.0, 433.0, TourneyApp.bracketNameSize, "Losers 7")
        values["Losers 7 Wins"] = PlayerValues(635.0, 433.0, TourneyApp.bracketWinsSize, "Losers 7 Wins").black()

        values["Losers 8"] = PlayerValues(430.0, 474.0, TourneyApp.bracketNameSize, "Losers 8")
        values["Losers 8 Wins"] = PlayerValues(635.0, 474.0, TourneyApp.bracketWinsSize, "Losers 8 Wins").black()
    }

}