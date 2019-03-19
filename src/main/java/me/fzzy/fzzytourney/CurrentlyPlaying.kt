package me.fzzy.fzzytourney

object CurrentlyPlaying {

    val names = arrayListOf<ObsField>()
    val wins = arrayListOf<ObsField>()

    val player1 get() = names[0]
    val player1Wins get() = wins[0]

    val player2 get() = names[1]
    val player2Wins get() = wins[1]

    init {
        names.add(ObsField(440.0, 0.0, TourneyApp.bracketNameSize, "Player 1"))
        wins.add(ObsField(648.0, 0.0, TourneyApp.bracketWinsSize, "Player 1 Wins").wins())

        names.add(ObsField(811.0, 0.0, TourneyApp.bracketNameSize, "Player 2"))
        wins.add(ObsField(768.0, 0.0, TourneyApp.bracketWinsSize, "Player 2 Wins").wins())
    }

}