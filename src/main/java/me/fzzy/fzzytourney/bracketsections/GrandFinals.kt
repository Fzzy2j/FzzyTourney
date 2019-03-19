package me.fzzy.fzzytourney.bracketsections

import me.fzzy.fzzytourney.ObsField
import me.fzzy.fzzytourney.TourneyApp
import me.fzzy.fzzytourney.util.SetName
import me.fzzy.fzzytourney.util.SmashGGApi

object GrandFinals {

    val names = arrayListOf<ObsField>()
    val wins = arrayListOf<ObsField>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    init {
        names.add(ObsField(780.0, 134.0, TourneyApp.bracketNameSize, "Grand Finals 1"))
        wins.add(ObsField(985.0, 134.0, TourneyApp.bracketWinsSize, "Grand Finals 1 Wins").wins())

        names.add(ObsField(780.0, 175.0, TourneyApp.bracketNameSize, "Grand Finals 2"))
        wins.add(ObsField(985.0, 175.0, TourneyApp.bracketWinsSize, "Grand Finals 2 Wins").wins())
    }

    fun update(api: SmashGGApi) {
        val s = api.getSets(SetName.GRAND_FINAL).sortedBy { it.identifier }
        player1.text = api.getEntrantName(s[0].entrant1SeedId)
        player2.text = api.getEntrantName(s[0].entrant2SeedId)
        player1Wins.text = s[0].entrant1Score.toString()
        player2Wins.text = s[0].entrant2Score.toString()
    }

}