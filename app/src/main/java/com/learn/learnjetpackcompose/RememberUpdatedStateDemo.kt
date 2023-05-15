package com.learn.learnjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import kotlinx.coroutines.delay

class RememberUpdatedStateDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    var counter by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter = 10
    }

    Counter(counter)

}

@Composable
fun Counter(value: Int) {
    val state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("RememberUpdatedStateDemo", state.value.toString())
    }

    Text(text = value.toString())
}


