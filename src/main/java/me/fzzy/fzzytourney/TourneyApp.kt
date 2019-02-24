package me.fzzy.fzzytourney

import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.layout.*
import javafx.stage.Stage
import me.fzzy.fzzytourney.bracketsections.*
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.util.*

class TourneyApp : Application() {


    lateinit var bgImage: Image

    companion object {

        val bracketNameSize = Pair(200.0, 35.0)
        val bracketWinsSize = Pair(35.0, 35.0)

        lateinit var pane: Pane

        @JvmStatic
        fun main(args: Array<String>) {
            launch(TourneyApp::class.java)
        }

        fun applyChanges() {
            for (child in pane.children) {
                if (child is PlayerValues) {
                    Files.write(File("data" + File.separator + child.name + ".txt").toPath(), Arrays.asList(child.text), Charset.forName("UTF-8"))
                }
            }
        }
    }

    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "FzzyTourney v0.1"
        primaryStage?.isResizable = false

        pane = Pane()
        bgImage = Image(TourneyApp::class.java.getResourceAsStream("/brackettemplate.png"))

        pane.children.addAll(WinnersSemis.names)
        pane.children.addAll(Losers.names)
        pane.children.addAll(WinnersFinals.names)
        pane.children.addAll(GrandFinals.names)
        pane.children.addAll(LosersSemis.names)
        pane.children.addAll(LosersFinals.names)

        pane.children.addAll(WinnersSemis.wins)
        pane.children.addAll(Losers.wins)
        pane.children.addAll(WinnersFinals.wins)
        pane.children.addAll(GrandFinals.wins)
        pane.children.addAll(LosersSemis.wins)
        pane.children.addAll(LosersFinals.wins)

        pane.children.addAll(CurrentlyPlaying.names)
        pane.children.addAll(CurrentlyPlaying.wins)

        val applyButton = Button("Apply")
        applyButton.prefWidth = 100.0
        applyButton.prefHeight = 50.0
        applyButton.layoutX = bgImage.width - applyButton.prefWidth - 20
        applyButton.layoutY = bgImage.height - applyButton.prefHeight - 20

        applyButton.onAction = EventHandler {
            applyChanges()
        }
        pane.children.addAll(applyButton)

        val resetButton = Button("Reset")
        resetButton.prefWidth = 100.0
        resetButton.prefHeight = 50.0
        resetButton.layoutX = bgImage.width - applyButton.prefWidth - resetButton.prefWidth - 40
        resetButton.layoutY = bgImage.height - resetButton.prefHeight - 20

        resetButton.onAction = EventHandler {
            for (child in pane.children) {
                if (child is PlayerValues) {
                    child.resetToDefault()
                }
            }
        }
        pane.children.addAll(resetButton)

        val scene = Scene(pane, bgImage.width, bgImage.height)
        pane.background = Background(BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT))
        primaryStage?.scene = scene
        primaryStage?.show()
    }
}