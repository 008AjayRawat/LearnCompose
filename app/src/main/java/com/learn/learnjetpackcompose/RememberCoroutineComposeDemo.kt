package com.learn.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import kotlinx.coroutines.launch

class RememberCoroutineComposeDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                LaunchedEffect(key1 = Unit){
                    hitServerAPI()
                }

                val scope = rememberCoroutineScope()
//                scope.launch {  } //Error:- Calls to launch should happen inside a LaunchedEffect and not composition
                Button(onClick = { scope.launch { hitServerAPI() } }) {

                }
            }
        }
    }

    private suspend fun hitServerAPI() {

    }

}