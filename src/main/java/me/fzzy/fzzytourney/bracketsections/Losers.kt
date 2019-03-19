package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName
import me.fzzy.fzzytourney.util.SmashGGApi

object Losers {

    val names = arrayListOf<ObsField>()
    val wins = arrayListOf<ObsField>()

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
        names.add(ObsField(80.0, 325.0, TourneyApp.bracketNameSize, "Losers 1"))
        wins.add(ObsField(285.0, 325.0, TourneyApp.bracketWinsSize, "Losers 1 Wins").wins())

        names.add(ObsField(80.0, 367.0, TourneyApp.bracketNameSize, "Losers 2"))
        wins.add(ObsField(285.0, 367.0, TourneyApp.bracketWinsSize, "Losers 2 Wins").wins())

        names.add(ObsField(80.0, 433.0, TourneyApp.bracketNameSize, "Losers 3"))
        wins.add(ObsField(285.0, 433.0, TourneyApp.bracketWinsSize, "Losers 3 Wins").wins())

        names.add(ObsField(80.0, 474.0, TourneyApp.bracketNameSize, "Losers 4"))
        wins.add(ObsField(285.0, 474.0, TourneyApp.bracketWinsSize, "Losers 4 Wins").wins())

        names.add(ObsField(430.0, 325.0, TourneyApp.bracketNameSize, "Losers 5"))
        wins.add(ObsField(635.0, 325.0, TourneyApp.bracketWinsSize, "Losers 5 Wins").wins())

        names.add(ObsField(430.0, 367.0, TourneyApp.bracketNameSize, "Losers 6"))
        wins.add(ObsField(635.0, 367.0, TourneyApp.bracketWinsSize, "Losers 6 Wins").wins())

        names.add(ObsField(430.0, 433.0, TourneyApp.bracketNameSize, "Losers 7"))
        wins.add(ObsField(635.0, 433.0, TourneyApp.bracketWinsSize, "Losers 7 Wins").wins())

        names.add(ObsField(430.0, 474.0, TourneyApp.bracketNameSize, "Losers 8"))
        wins.add(ObsField(635.0, 474.0, TourneyApp.bracketWinsSize, "Losers 8 Wins").wins())
    }

    fun update(api: SmashGGApi) {
        val s1 = api.getSets(SetName.LOSERS_ROUND(api.totalLoserRounds)).sortedBy { it.identifier }
        player1.text = api.getEntrantName(s1[0].entrant1SeedId)
        player2.text = api.getEntrantName(s1[0].entrant2SeedId)
        player1Wins.text = s1[0].entrant1Score.toString()
        player2Wins.text = s1[0].entrant2Score.toString()

        player3.text = api.getEntrantName(s1[1].entrant1SeedId)
        player4.text = api.getEntrantName(s1[1].entrant2SeedId)
        player3Wins.text = s1[1].entrant1Score.toString()
        player4Wins.text = s1[1].entrant2Score.toString()

        val s2 = api.getSets(SetName.LOSERS_QUARTER_FINAL).sortedBy { it.identifier }
        player5.text = api.getEntrantName(s2[0].entrant1SeedId)
        player6.text = api.getEntrantName(s2[0].entrant2SeedId)
        player5Wins.text = s2[0].entrant1Score.toString()
        player6Wins.text = s2[0].entrant2Score.toString()

        player7.text = api.getEntrantName(s2[1].entrant1SeedId)
        player8.text = api.getEntrantName(s2[1].entrant2SeedId)
        player7Wins.text = s2[1].entrant1Score.toString()
        player8Wins.text = s2[1].entrant2Score.toString()
    }

}