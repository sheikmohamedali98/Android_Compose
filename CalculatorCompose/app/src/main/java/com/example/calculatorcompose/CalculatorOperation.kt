package com.example.calculatorcompose

sealed class CalculatorOperation(val symbol:String){
    object Addition:CalculatorOperation("+")
    object Subtract:CalculatorOperation("-")
    object  Multiply:CalculatorOperation("*")
    object  Divide:CalculatorOperation("/")
}
