package com.jatinvashisht.clockcomposableexercise.clock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ClockStyle(
    val background: Color = Color.LightGray,
    val circleRadius: Float = 100f,
    val lineColor: Color = Color.Red,
    val startingPoint: Int = 1,
    val endingPoint: Int = 12,
    val textSize: Dp = 20.dp,
    val innerCircleRadius: Int = 20,
    val innerCircleColor: Color = Color.Red,
    val secondHandColor: Color = Color.Green,
    val secondHandWidth: Int = 5,

    val hourHandColor: Color = Color.Magenta,
    val minuteHandColor: Color = Color.Blue
)
