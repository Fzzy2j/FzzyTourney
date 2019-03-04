package me.fzzy.fzzytourney.util

object SetName {
    val GRAND_FINAL = "Grand Final"
    val LOSERS_FINAL = "Losers Final"
    val WINNERS_FINAL = "Winners Final"
    val LOSERS_SEMIS = "Losers Semi-Final"
    val WINNERS_SEMIS = "Winners Semi-Final"
    val LOSERS_QUARTER_FINAL = "Losers Quarter-Final"

    fun LOSERS_ROUND(roundN: Int): String {
        return "Losers Round $roundN"
    }
}