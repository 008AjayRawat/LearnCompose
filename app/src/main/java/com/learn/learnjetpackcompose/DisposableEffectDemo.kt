package com.learn.learnjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class DisposableEffectDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme() {
                DisposableEffect(key1 = Unit) {
                    Log.d("DisposableEffectDemo","Line 1")
                    onDispose {
                        Log.d("DisposableEffectDemo","Line 2 Dispose")
                    }
                }
            }
        }
    }
}