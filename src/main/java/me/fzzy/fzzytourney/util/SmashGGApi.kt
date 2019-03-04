package me.fzzy.fzzytourney.util

import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SmashGGApi(id: Int) {

    private val url = URL("https://api.smash.gg/phase_group/$id?expand[]=sets&expand[]=seeds")

    private lateinit var json: JSONObject
    private val sets = arrayListOf<Set>()

    var totalLoserRounds: Int = 0
        private set

    init {
        refresh()
    }

    fun refresh() {
        totalLoserRounds = 0
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        val rd = BufferedReader(InputStreamReader(conn.inputStream))
        json = JSONObject(rd.readLine())
        rd.close()

        val array = json.getJSONObject("entities").getJSONArray("sets")
        for (i in 0 until array.count()) {
            try {
                val s = Set(this, array.getJSONObject(i))
                sets.add(s)
                if (s.fullRoundText.startsWith("Losers Round ")) {
                    val roundN = s.fullRoundText.substring(s.fullRoundText.length - 1).toInt()
                    if (roundN > totalLoserRounds) totalLoserRounds = roundN
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getSets(fullRoundText: String): ArrayList<Set> {
        val setList = arrayListOf<Set>()
        setList.addAll(sets.filter { set -> set.fullRoundText == fullRoundText })
        return setList
    }

    fun getEntrantName(seedId: Long?): String {
        val seeds = json.getJSONObject("entities").getJSONArray("seeds")
        for (i in 0 until seeds.count()) {
            val seed = seeds.getJSONObject(i)
            if (seed.getLong("id") == seedId) {
                val players = seed.getJSONObject("mutations").getJSONObject("players").names().get(0)
                return seed.getJSONObject("mutations").getJSONObject("players").getJSONObject(players as String).getString("gamerTag")
            }
        }
        return ""
    }

    class Set constructor(api: SmashGGApi, json: JSONObject) {
        var fullRoundText = json.getString("fullRoundText")
        var entrant1Score = json.getInt("entrant1Score")
        var entrant2Score = json.getInt("entrant2Score")
        var entrant1SeedId = try {
            json.getJSONArray("slots").getJSONObject(0).getLong("seedId")
        } catch (e: Exception) {
            null
        }
        var entrant2SeedId = try {
            json.getJSONArray("slots").getJSONObject(1).getLong("seedId")
        } catch (e: Exception) {
            null
        }
        var identifier = json.getString("identifier")
    }

}