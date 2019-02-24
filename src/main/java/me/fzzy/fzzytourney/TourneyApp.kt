package me.fzzy.fzzytourney

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.*
import javafx.stage.Stage
import me.fzzy.fzzytourney.bracketsections.Losers
import me.fzzy.fzzytourney.bracketsections.WinnersSemis

class TourneyApp : Application() {


    lateinit var bgImage: Image

    companion object {

        val bracketNameSize = Pair(200.0, 35.0)
        val bracketWinsSize = Pair(35.0, 35.0)

        @JvmStatic
        fun main(args: Array<String>) {
            launch(TourneyApp::class.java)
        }
    }

    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "FzzyTourney v0.1"
        primaryStage?.isResizable = false

        val pane = Pane()
        bgImage = Image(TourneyApp::class.java.getResourceAsStream("/brackettemplate.png"))

        pane.children.addAll(WinnersSemis.all)
        pane.children.addAll(Losers.all)

        val scene = Scene(pane, bgImage.width, bgImage.height)
        pane.background = Background(BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT))
        primaryStage?.scene = scene
        primaryStage?.show()
    }
}