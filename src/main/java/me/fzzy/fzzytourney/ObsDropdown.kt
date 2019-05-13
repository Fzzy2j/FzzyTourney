package me.fzzy.fzzytourney

import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.scene.control.ComboBox
import javafx.scene.input.KeyCode
import javafx.scene.layout.Background
import me.fzzy.fzzytourney.util.Coordinates
import java.io.File
import java.nio.file.Files

class ObsDropdown(x: Double, y: Double, size: Coordinates, val name: String, val options: ObservableList<String>) : ComboBox<String>(options) {

    private var ogText = ""

    var isWinsValue = false

    fun setWinsValue(): ObsDropdown {
        this.style = "-fx-text-fill: black;"
        this.ogText = "0"
        isWinsValue = true
        return this
    }

    private var uppercase = false

    fun onlyUppercase(): ObsDropdown {
        uppercase = true
        return this
    }

    fun resetToDefault() {
        this.value = ogText
    }

    init {
        this.style = "-fx-text-fill: white;"
        this.background = Background.EMPTY
        this.prefWidth = size.x
        this.prefHeight = size.y
        this.layoutX = x
        this.layoutY = y

        val file = File("data${File.separator}$name.txt")
        if (file.exists()) this.value = Files.readAllLines(file.toPath())[0]

        this.onAction = EventHandler {
            TourneyApp.applyChanges()
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