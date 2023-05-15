package com.learn.learnjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                Column(modifier = Modifier.fillMaxSize()) {

                    var counter = remember { mutableStateOf(0) }
                    Button(onClick = { counter.value++ }) {
                        Text(text = "Update Counter ${counter.value}")
                    }

                    //LaunchedEffectDemo(value = counter.value)

                    DisposableEffectDemo(counter.value)
                }
            }
        }
    }
    

    @Composable
    fun LaunchedEffectDemo(value: Int) {
        LaunchedEffect(key1 = Unit) {
            Log.d("LaunchedEffectDemo", "Line 1 and value $value")
        }

        Log.d("LaunchedEffectDemo", "Line 2 and value $value")

    }
    
    
    @Composable
    fun DisposableEffectDemo(value:Int){

        Log.d("DisposableEffectDemo","Line 1")

        DisposableEffect(key1 = value){

            Log.d("DisposableEffectDemo","Line 2")

            onDispose {
                Log.d("DisposableEffectDemo","Line 3")
            }
        }

        Log.d("DisposableEffectDemo","Line 5")
    }

}
