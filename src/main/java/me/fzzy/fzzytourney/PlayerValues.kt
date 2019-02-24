package me.fzzy.fzzytourney

import javafx.scene.control.TextField
import javafx.scene.layout.Background

class PlayerValues constructor(x: Double, y: Double, size: Pair<Double, Double>, name: String) : TextField() {

    fun black(): PlayerValues {
        this.style = "-fx-text-fill: black;"
        return this
    }

    init {
        this.style = "-fx-text-fill: white;"
        //this.background = Background.EMPTY
        this.prefWidth = size.first
        this.prefHeight = size.second
        this.layoutX = x
        this.layoutY = y
    }

}