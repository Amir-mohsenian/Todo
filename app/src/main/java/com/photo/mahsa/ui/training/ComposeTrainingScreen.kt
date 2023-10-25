package com.photo.mahsa.ui.training

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.photo.mahsa.ui.theme.MahsaTheme


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ComposeTrainingScreen() {
    var visible by remember {
        mutableStateOf(true)
    }

    var state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    var count by remember {
        mutableIntStateOf(1)
    }

    var enabled by remember {
        mutableStateOf(false)
    }
    val alpha: Float by animateFloatAsState(
        if (enabled) 1f else 0.5f,
        label = "",
        animationSpec = tween(durationMillis = 500)
    )
    val height: Dp by animateDpAsState(
        if (enabled) 300.dp else 120.dp,
        label = "",
        animationSpec = tween(durationMillis = 500)
    )
    val offset: IntOffset by animateIntOffsetAsState(
        if (enabled) IntOffset(
            x = 0,
            y = 50
        ) else IntOffset.Zero, label = "", animationSpec = tween(durationMillis = 500)
    )
    val color: Color by animateColorAsState(
        if (enabled) Color.LightGray else Color.DarkGray,
        label = "",
        animationSpec = tween(durationMillis = 500)
    )

    var currentState by remember { mutableStateOf(BoxState.Collapsed) }

    val transition = updateTransition(currentState, label = "box state")


    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            visible = !visible
        }) {
            Text(text = "Toggle it to visibility")
        }

        Button(onClick = {
            visible = !visible
        }) {
            Text(text = "Toggle it to animate content")
        }

        Button(onClick = {
            count++

        }) {
            Text(text = "Add ++")
        }

        Button(onClick = {
            enabled = !enabled
        }) {
            Text(text = "Change Alpha")
        }

        Row(
            modifier = Modifier
                .offset { offset }
                .fillMaxWidth()
                .height(height)
                .graphicsLayer(alpha = alpha, shadowElevation = alpha)
                .background(color)
        ) {

        }

        AnimatedContent(targetState = count, transitionSpec = {
            scaleIn() + expandHorizontally() with
                    scaleOut() + shrinkHorizontally()
        }, content = { targetContent ->
            Text(text = "$targetContent", fontSize = 20.sp)

        }, label = "")

        AnimatedVisibility(
            visible = visible,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                        .height(100.dp)
                ) {

                }

                Row(
                    modifier = Modifier
                        .animateEnterExit(
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .background(Color.DarkGray)

                        .fillMaxWidth()
                        .height(100.dp)
                ) {

                }

                Row(
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxWidth()
                        .height(100.dp)
                ) {

                }
            }
        }
    }
}

enum class BoxState {
    Collapsed,
    Expanded
}

@SuppressLint("InvalidWakeLockTag")
@Composable
fun SameTimeAnimCompose() {

}

enum class Banner {
    FOOTER,
    HEADER
}

@Preview
@Composable
fun ComposeTrainingPreview() {
    MahsaTheme {
        SameTimeAnimCompose()
    }
}