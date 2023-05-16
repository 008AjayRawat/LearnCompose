package com.learn.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class SwipeAndPullToRefreshList : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {

            }
        }
    }
}