package me.fzzy.fzzytourney

object CurrentlyPlaying {

    fun init() {
        val player1 = ObsField(440.0, 0.0, TourneyApp.bracketNameSize, "Player 1")
        val player1Wins = ObsField(648.0, 0.0, TourneyApp.bracketWinsSize, "Player 1 Wins").setWinsValue()
        val player2 = ObsField(811.0, 0.0, TourneyApp.bracketNameSize, "Player 2")
        val player2Wins = ObsField(768.0, 0.0, TourneyApp.bracketWinsSize, "Player 2 Wins").setWinsValue()

        Sets.addSet(Sets.TourneySet(player1, player1Wins, player2, player2Wins, null))
    }

}