package me.fzzy.fzzytourney

import me.fzzy.fzzytourney.util.SmashGGApi

object AutoFillThread : Thread() {

    val api = SmashGGApi()
    var running = true

    override fun run() {
        while (running) {
            if (TourneyApp.autoToggle.isSelected) {
                api.id = TourneyApp.tourneyIdField.text.toInt()
                api.refresh()
                for (set in Sets.getSets()) {
                    if (set.identifier == null || set.identifier.text.isEmpty()) continue
                    val smashSet = api.getSet(set.identifier.text) ?: continue
                    set.player1.text = api.getEntrantName(smashSet.entrant1SeedId)
                    set.player1Wins.text = smashSet.entrant1Score.toString()
                    set.player2.text = api.getEntrantName(smashSet.entrant2SeedId)
                    set.player2Wins.text = smashSet.entrant2Score.toString()
                }
            }
            Thread.sleep(5000)
        }
    }

}