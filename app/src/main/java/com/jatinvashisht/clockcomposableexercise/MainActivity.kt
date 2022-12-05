package com.jatinvashisht.clockcomposableexercise

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jatinvashisht.clockcomposableexercise.clock.ClockComposable
import com.jatinvashisht.clockcomposableexercise.clock.ClockStyle
import com.jatinvashisht.clockcomposableexercise.ui.theme.ClockComposableExerciseTheme
import kotlinx.coroutines.delay
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockComposableExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val milliseconds = remember {
                        mutableStateOf(LocalTime.now())
                    }
                    var second by remember{
                        mutableStateOf(milliseconds.value.second)
                    }

                    var minutes by remember{
                        mutableStateOf((milliseconds.value.minute.toFloat()))
                    }

                    var hours by remember{
                        mutableStateOf((milliseconds.value.hour.toFloat()/2f))
                    }

//                    Log.d("MainActivity", "hours is $hours")
                    BoxWithConstraints(modifier = Modifier.fillMaxSize()){
                        val circleRadius = this.maxWidth - 100.dp
                        LaunchedEffect(key1 = second) {
                            delay(1000L)
                            second+=1
                            minutes += 1f/60f
                            hours += 1f/3600f

                        }
                        ClockComposable(
                            modifier = Modifier.fillMaxSize(),
                            clockStyle = ClockStyle(circleRadius = circleRadius.value),
                            seconds = second,
                            minutes = minutes,
                            hours = hours
                        )
                    }
                }
            }
        }
    }
}
