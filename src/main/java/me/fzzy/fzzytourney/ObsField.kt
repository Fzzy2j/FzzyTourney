package me.fzzy.fzzytourney

import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.layout.Background
import me.fzzy.fzzytourney.util.Coordinates
import java.io.File
import java.nio.file.Files

class ObsField constructor(x: Double, y: Double, size: Coordinates, val name: String) : TextField() {

    private var ogText = ""

    fun setWinsValue(): ObsField {
        this.style = "-fx-text-fill: black;"
        this.ogText = "0"
        return this
    }

    private var uppercase = false

    fun onlyUppercase(): ObsField {
        uppercase = true
        return this
    }

    override fun replaceText(start: Int, end: Int, text: String?) {
        if (uppercase)
            super.replaceText(start, end, text?.toUpperCase())
        else
            super.replaceText(start, end, text)
    }

    fun resetToDefault() {
        this.text = ogText
    }

    init {
        this.style = "-fx-text-fill: white;"
        this.alignment = Pos.CENTER
        this.background = Background.EMPTY
        this.prefWidth = size.x
        this.prefHeight = size.y
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