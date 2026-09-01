package br.edu.ifsp.scl.sc3039587.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PingPongViewModel : ViewModel() {
    var scoreA by mutableIntStateOf(0)
        private set

    var scoreB by mutableIntStateOf(0)
        private set

    fun incrementScoreA() {
        scoreA++
    }

    fun incrementScoreB() {
        scoreB++
    }

    fun resetMatch() {
        scoreA = 0
        scoreB = 0
    }
}