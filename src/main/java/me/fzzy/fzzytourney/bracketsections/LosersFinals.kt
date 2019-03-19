package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName
import me.fzzy.fzzytourney.util.SmashGGApi

object LosersFinals {

    val names = arrayListOf<ObsField>()
    val wins = arrayListOf<ObsField>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    init {
        names.add(ObsField(1130.0, 325.0, TourneyApp.bracketNameSize, "Losers Finals 1"))
        wins.add(ObsField(1335.0, 325.0, TourneyApp.bracketWinsSize, "Losers Finals 1 Wins").wins())

        names.add(ObsField(1130.0, 367.0, TourneyApp.bracketNameSize, "Losers Finals 2"))
        wins.add(ObsField(1335.0, 367.0, TourneyApp.bracketWinsSize, "Losers Finals 2 Wins").wins())
    }

    fun update(api: SmashGGApi) {
        val s = api.getSets(SetName.LOSERS_FINAL).sortedBy { it.identifier }
        player1.text = api.getEntrantName(s[0].entrant1SeedId)
        player2.text = api.getEntrantName(s[0].entrant2SeedId)
        player1Wins.text = s[0].entrant1Score.toString()
        player2Wins.text = s[0].entrant2Score.toString()
    }

}