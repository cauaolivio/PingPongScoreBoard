package br.edu.ifsp.scl.sc3039587.pingpongscoreboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PingPongViewModel : ViewModel() {
    private val _scoreA = MutableStateFlow(0)
    val scoreA: StateFlow<Int> = _scoreA.asStateFlow()

    private val _scoreB = MutableStateFlow(0)
    val scoreB: StateFlow<Int> = _scoreB.asStateFlow()

    fun incrementScoreA() {
        _scoreA.value++
    }

    fun incrementScoreB() {
        _scoreB.value++
    }

    fun resetMatch() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}