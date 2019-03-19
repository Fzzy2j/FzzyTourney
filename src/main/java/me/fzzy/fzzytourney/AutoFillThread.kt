package me.fzzy.fzzytourney

import me.fzzy.fzzytourney.bracketsections.*
import me.fzzy.fzzytourney.util.SmashGGApi

object AutoFillThread : Thread() {

    val api = SmashGGApi()
    var running = true

    override fun run() {
        while (running) {
            if (TourneyApp.autoToggle.isSelected) {
                api.id = TourneyApp.tourneyIdField.text.toInt()
                api.refresh()
                try {
                    GrandFinals.update(api)
                    LosersFinals.update(api)
                    WinnersFinals.update(api)
                    LosersSemis.update(api)
                    WinnersSemis.update(api)
                    Losers.update(api)
                } catch (e: Exception) {
                }
            }
            Thread.sleep(5000)
        }
    }

}