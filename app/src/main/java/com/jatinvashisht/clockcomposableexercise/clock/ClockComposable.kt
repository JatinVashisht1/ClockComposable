package com.jatinvashisht.clockcomposableexercise.clock

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.core.graphics.withRotation
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ClockComposable(
    modifier: Modifier,
    clockStyle: ClockStyle = ClockStyle(),
    seconds: Int,
    minutes: Float,
    hours: Float
) {
    val startingPoint = clockStyle.startingPoint
    val endingPoint = clockStyle.endingPoint
    Canvas(
        modifier = modifier
    ){
        val circleCenter = this.center
        val circleRadius = clockStyle.circleRadius
        drawCircle(
            color = clockStyle.background,
            radius = circleRadius,
            center = circleCenter,
        )
        for(i in startingPoint .. endingPoint){
            val angleInRad = (i - startingPoint) * (360/endingPoint) * (PI / 180f).toFloat() - 1
            Log.d("clockComposable", "angle in radian is $angleInRad")
            val lineStart = Offset(
                // this means start from 50 dp away from circumference of circle
                x = (circleRadius - 50) * cos(angleInRad) + circleCenter.x,
                y = (circleRadius - 50) * sin(angleInRad) + circleCenter.y,
            )
            val lineEnd = Offset(
                x = circleRadius * cos(angleInRad) + circleCenter.x,
                y = circleRadius * sin(angleInRad) + circleCenter.y,
            )
            drawLine(
                color = clockStyle.lineColor,
                start = lineStart,
                end = lineEnd
            )

            drawContext.canvas.nativeCanvas.apply {
                val textRadius = circleRadius - 55 - clockStyle.textSize.toPx()
                val x = textRadius * cos(angleInRad) + circleCenter.x + 0
                val y = textRadius * sin(angleInRad) + circleCenter.y + 0

                withRotation(
                    angleInRad*(180f/PI).toFloat() + 90f,
                    pivotX = x,
                    pivotY = y
                ) {
                    drawText(
                        i.toString(),
                        x,
                        y,
                        Paint().apply {
                            textSize = clockStyle.textSize.toPx()
                            textAlign = Paint.Align.CENTER
                        }
                    )
                }
            }

            rotate(
                degrees = hours * (360/60f) + 0
            ){
                drawLine(
                    color = clockStyle.hourHandColor,
                    start = circleCenter,
                    end = Offset(circleCenter.x, circleCenter.y - 145),
                    strokeWidth = clockStyle.secondHandWidth.toFloat()
                )
            }

            rotate(
                degrees = seconds * (360/60f) + 8,
            ){
                drawLine(
                    color = clockStyle.secondHandColor,
                    start = circleCenter,
                    end = Offset(circleCenter.x, circleCenter.y - 190),
                    strokeWidth = clockStyle.secondHandWidth.toFloat()
                )
            }

            rotate(
                degrees = minutes * (360/60f) + 1,
            ){
                drawLine(
                    color = clockStyle.minuteHandColor,
                    start = circleCenter,
                    end = Offset(circleCenter.x, circleCenter.y - 160),
                    strokeWidth = clockStyle.secondHandWidth.toFloat()
                )
            }

            drawCircle(
                color = clockStyle.innerCircleColor,
                radius = clockStyle.innerCircleRadius.toFloat(),
                center = circleCenter
            )
        }
    }
}