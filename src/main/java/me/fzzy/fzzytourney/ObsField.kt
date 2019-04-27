package me.fzzy.fzzytourney

import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.input.KeyCode
import javafx.scene.layout.Background
import me.fzzy.fzzytourney.util.Coordinates
import java.io.File
import java.nio.file.Files

class ObsField constructor(x: Double, y: Double, size: Coordinates, val name: String) : TextField() {

    private var ogText = ""

    var isWinsValue = false

    fun setWinsValue(): ObsField {
        this.style = "-fx-text-fill: black;"
        this.ogText = "0"
        isWinsValue = true
        return this
    }

    private var uppercase = false

    fun onlyUppercase(): ObsField {
        uppercase = true
        return this
    }

    override fun replaceText(start: Int, end: Int, ch: String?) {
        if (uppercase)
            super.replaceText(start, end, ch?.toUpperCase())
        else
            super.replaceText(start, end, ch)

        if (ch.isNullOrBlank()) return

        val caretPos = this.caretPosition

        val textNoSelection = this.text.substring(0, this.selection.start) + this.text.substring(this.selection.end, this.text.length)
        var name = ""
        for (n in TourneyApp.names) {
            if (n.startsWith(textNoSelection) && n != textNoSelection) {
                name = n
                break
            }
        }

        if (name.isNotBlank()) this.text = name

        if (name.isNotBlank()) {
            this.positionCaret(caretPos)
            this.selectNextWord()
        }
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
            this.deselect()
            this.positionCaret(this.text.length)
        }
        this.setOnKeyPressed {
            if (it.code == KeyCode.LEFT) {
                val p1 = Sets.getSets("Currently Playing")[0].player1Wins
                p1.text = (p1.text.toInt() + 1).toString()
            }
            if (it.code == KeyCode.RIGHT) {
                val p2 = Sets.getSets("Currently Playing")[0].player2Wins
                p2.text = (p2.text.toInt() + 1).toString()
            }
            if (it.code == KeyCode.DOWN) {
                Sets.getSets("Currently Playing")[0].player1Wins.resetToDefault()
                Sets.getSets("Currently Playing")[0].player1.resetToDefault()
                Sets.getSets("Currently Playing")[0].player2Wins.resetToDefault()
                Sets.getSets("Currently Playing")[0].player2.resetToDefault()
            }
        }
    }

}