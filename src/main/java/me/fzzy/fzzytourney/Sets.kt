package me.fzzy.fzzytourney

import javafx.scene.layout.Pane

object Sets {

    private val sets = arrayListOf<TourneySet>()

    fun addSet(set: TourneySet) {
        sets.add(set)
    }

    fun addSetsToPane(pane: Pane) {
        for (set in sets) {
            if (set.reorderTab) {
                pane.children.add(set.player1)
                pane.children.add(set.player2)
                pane.children.add(set.player1Wins)
                pane.children.add(set.player2Wins)
            } else {
                pane.children.add(set.player1)
                pane.children.add(set.player1Wins)
                pane.children.add(set.player2)
                pane.children.add(set.player2Wins)
            }
        }
    }

    fun getSets(): ArrayList<TourneySet> {
        return sets
    }

    fun getSets(name: String): List<TourneySet> {
        return sets.filter { set -> set.name == name }
    }

    class TourneySet constructor(val name: String, val player1: ObsField, val player1Wins: ObsField, val player2: ObsField, val player2Wins: ObsField, val reorderTab: Boolean = false)

}