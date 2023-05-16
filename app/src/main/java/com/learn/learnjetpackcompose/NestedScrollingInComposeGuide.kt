package com.learn.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class NestedScrollingInComposeGuide : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                LazyColumn {
                    item {
                        LazyRow {
                            items(10) {
                                Text(
                                    text = "Item $it",
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                    }

                    //Cannot use LazyColumn inside another LazyColumn...same apply for LazyRow.
                }
            }
        }
    }
}