package com.example.calculatorcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewmodel:ViewModel() {

    var state by mutableStateOf(CalculateState())
        private set

}