package br.edu.ifsp.scl.sc3039587.pingpongscoreboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PingPongViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _scoreA = MutableStateFlow(savedStateHandle["scoreA"] ?: 0)
    val scoreA: StateFlow<Int> = _scoreA.asStateFlow()

    private val _scoreB = MutableStateFlow(savedStateHandle["scoreB"] ?: 0)
    val scoreB: StateFlow<Int> = _scoreB.asStateFlow()

    fun incrementScoreA() {
        _scoreA.value++
        savedStateHandle["scoreA"] = _scoreA.value
    }

    fun incrementScoreB() {
        _scoreB.value++
        savedStateHandle["scoreB"] = _scoreB.value
    }

    fun resetMatch() {
        _scoreA.value = 0
        _scoreB.value = 0
        savedStateHandle["scoreA"] = 0
        savedStateHandle["scoreB"] = 0
    }
}