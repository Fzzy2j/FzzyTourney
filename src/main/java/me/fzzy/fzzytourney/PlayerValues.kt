package me.fzzy.fzzytourney

import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.layout.Background

class PlayerValues constructor(x: Double, y: Double, size: Pair<Double, Double>, val name: String) : TextField() {

    fun wins(): PlayerValues {
        this.style = "-fx-text-fill: black;"
        this.text = "0"
        return this
    }

    init {
        this.style = "-fx-text-fill: white;"
        this.alignment = Pos.CENTER
        this.background = Background.EMPTY
        this.prefWidth = size.first
        this.prefHeight = size.second
        this.layoutX = x
        this.layoutY = y

        this.onMouseClicked = EventHandler {
            this.selectAll()
        }
    }

}