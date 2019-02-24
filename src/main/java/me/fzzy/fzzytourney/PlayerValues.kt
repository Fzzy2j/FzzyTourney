package me.fzzy.fzzytourney

import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.layout.Background
import java.io.File
import java.nio.file.Files

class PlayerValues constructor(x: Double, y: Double, size: Pair<Double, Double>, val name: String) : TextField() {

    private var ogText = ""

    fun wins(): PlayerValues {
        this.style = "-fx-text-fill: black;"
        this.text = "0"
        this.ogText = "0"
        return this
    }

    fun resetToDefault() {
        this.text = ogText
    }

    init {
        this.style = "-fx-text-fill: white;"
        this.alignment = Pos.CENTER
        this.background = Background.EMPTY
        this.prefWidth = size.first
        this.prefHeight = size.second
        this.layoutX = x
        this.layoutY = y

        val file = File("data${File.separator}$name.txt")
        if (file.exists()) this.text = Files.readAllLines(file.toPath())[0]

        this.onMouseClicked = EventHandler {
            this.selectAll()
        }
        this.onAction = EventHandler {
            TourneyApp.applyChanges()
        }
    }

}