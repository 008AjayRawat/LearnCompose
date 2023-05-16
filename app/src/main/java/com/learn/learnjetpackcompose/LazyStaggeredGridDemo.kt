package com.learn.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.learn.learnjetpackcompose.data.StaggeredItem
import com.learn.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
class LazyStaggeredGridDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = (1..100).map {
            StaggeredItem(
                height = Random.nextInt(100, 300).dp,
                color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = 1f)
            )
        }

        setContent {
            LearnJetpackComposeTheme {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalItemSpacing = 16.dp
                ) {
                    items(items) { item ->
                        RandomColorBox(item = item)
                    }
                }
            }
        }
    }
}


@Composable
fun RandomColorBox(item: StaggeredItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height)
            .clip(RoundedCornerShape(10.dp))
            .background(item.color)
    )
}


