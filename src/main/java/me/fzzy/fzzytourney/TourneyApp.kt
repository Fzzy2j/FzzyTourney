package me.fzzy.fzzytourney

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.control.ToggleButton
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.stage.Stage
import me.fzzy.fzzytourney.bracketsections.*
import me.fzzy.fzzytourney.util.Coordinates
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.file.Files
import java.util.*
import kotlin.math.round

class TourneyApp : Application() {

    lateinit var bgImage: Image

    companion object {

        val bracketNameSize = Coordinates(200.0, 35.0)
        val bracketWinsSize = Coordinates(35.0, 35.0)

        lateinit var pane: Pane

        val gson = Gson()
        var names = arrayListOf<String>()

        @JvmStatic
        fun main(args: Array<String>) {
            val namesFile = File("data${File.separator}cache${File.separator}names.json")
            val token = object : TypeToken<ArrayList<String>>() {}.type
            if (namesFile.exists())
                names = gson.fromJson(JsonReader(InputStreamReader(namesFile.inputStream())), token)

            launch(TourneyApp::class.java)
        }

        fun applyChanges() {
            for (child in pane.children) {
                File("data${File.separator}cache").mkdirs()
                if (child is ObsField) {
                    Files.write(File("data" + File.separator + child.name + ".txt").toPath(), Arrays.asList(child.text), Charset.forName("UTF-8"))
                    if (!child.isWinsValue && child.text.isNotBlank() && !names.contains(child.text)) names.add(child.text)
                }

                val namesFile = File("data${File.separator}cache${File.separator}names.json")
                val bufferWriter = BufferedWriter(FileWriter(namesFile.absoluteFile, false))
                val save = gson.toJson(names)
                bufferWriter.write(save)
                bufferWriter.close()
            }
        }

        fun resetToDefault() {
            for (child in pane.children) {
                if (child is ObsField) {
                    child.resetToDefault()
                }
            }
        }
    }

    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "FzzyTourney v0.1"
        primaryStage?.isResizable = false

        pane = Pane()
        bgImage = Image(TourneyApp::class.java.getResourceAsStream("/brackettemplate.png"))

        WinnersSemis.init()
        Losers.init()
        WinnersFinals.init()
        GrandFinals.init()
        LosersSemis.init()
        LosersFinals.init()

        pane.setOnKeyPressed {
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

        CurrentlyPlaying.init()

        Sets.addSetsToPane(pane)

        val roundIndicator = ObsField(510.0, 43.0, Coordinates(430.0, 35.0), "Round Indicator").onlyUppercase()
        roundIndicator.style = "-fx-text-fill: black;"
        pane.children.add(roundIndicator)

        val caster1 = ObsField(291.0, 568.0, Coordinates(147.0, 25.0), "Caster 1")
        pane.children.add(caster1)

        val caster1Tag = ObsField(291.0, 597.0, Coordinates(147.0, 25.0), "Caster 1 Tag")
        pane.children.add(caster1Tag)

        val caster2 = ObsField(525.0, 568.0, Coordinates(147.0, 25.0), "Caster 2")
        pane.children.add(caster2)

        val caster2Tag = ObsField(525.0, 597.0, Coordinates(147.0, 25.0), "Caster 2 Tag")
        pane.children.add(caster2Tag)

        val applyButton = Button("Apply")
        applyButton.prefWidth = 100.0
        applyButton.prefHeight = 50.0
        applyButton.layoutX = bgImage.width - applyButton.prefWidth - 20
        applyButton.layoutY = bgImage.height - applyButton.prefHeight - 20

        applyButton.onAction = EventHandler {
            applyChanges()
        }
        pane.children.add(applyButton)

        val resetButton = Button("Reset")
        resetButton.prefWidth = 100.0
        resetButton.prefHeight = 50.0
        resetButton.layoutX = bgImage.width - applyButton.prefWidth - resetButton.prefWidth - 40
        resetButton.layoutY = bgImage.height - resetButton.prefHeight - 20

        resetButton.onAction = EventHandler {
            resetToDefault()
        }
        pane.children.add(resetButton)

        if (!File("data").exists()) {
            resetToDefault()
        }

        val scene = Scene(pane, bgImage.width, bgImage.height)
        pane.background = Background(BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT))
        primaryStage?.scene = scene
        primaryStage?.show()
    }
}