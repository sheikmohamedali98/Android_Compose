package com.example.calculatorcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorcompose.ui.theme.LightGray
import com.example.calculatorcompose.ui.theme.MediumGray
import com.example.calculatorcompose.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculateState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction:(CalculatorAction)->Unit
){
    
    Box(modifier = modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {
            
            Text(text = state.number1 + (state.operation ?: "")+ state.number2,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
            color =  Color.White,
            maxLines = 2)
            
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "Ac", modifier = Modifier.background(LightGray).aspectRatio(2f).weight(2f),
                onClick = {
                  onAction(CalculatorAction.Clear)
                })

                CalculatorButton(symbol = "Del", modifier = Modifier.background(LightGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    })

                CalculatorButton(symbol = "/", modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    })

            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "7", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    })

                CalculatorButton(symbol = "8", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    })
                CalculatorButton(symbol = "9", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    })

                CalculatorButton(symbol = "X", modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    })
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "4", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    })

                CalculatorButton(symbol = "5", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    })
                CalculatorButton(symbol = "6", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    })

                CalculatorButton(symbol = "-", modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    })
            }



        }
        
    }

}