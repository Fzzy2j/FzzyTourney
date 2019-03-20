package me.fzzy.fzzytourney

import javafx.scene.layout.Pane

object Sets {

    private val sets = arrayListOf<TourneySet>()

    fun addSet(set: TourneySet) {
        sets.add(set)
    }

    fun addSetsToPane(pane: Pane) {
        for (set in sets) {
            pane.children.add(set.player1)
            pane.children.add(set.player2)
        }
        for (set in sets) {
            pane.children.add(set.player1Wins)
            pane.children.add(set.player2Wins)
        }
        for (set in sets) {
            if (set.identifier != null) pane.children.add(set.identifier)
        }
    }

    fun getSets(): ArrayList<TourneySet> {
        return sets
    }

    class TourneySet constructor(val player1: ObsField, val player1Wins: ObsField, val player2: ObsField, val player2Wins: ObsField, val identifier: ObsField?)

}