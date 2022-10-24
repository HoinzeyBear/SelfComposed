package com.example.selfcomposed.imitations

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.selfcomposed.ui.theme.ButtonShadow
import com.example.selfcomposed.ui.theme.TwitterBlue

@Composable
fun Twitter() {
    MaterialTheme {
        MainContainer(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun MainContainer(modifier: Modifier) {
    /*
    Stuff for the lists etc
     */
    Box(modifier = modifier) {

        var fabState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
        if (fabState == MultiFabState.EXPANDED) {
            OpacityScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.9F)
                    .background(color = Color.White)
            )
        }



        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            onStateChanged = { newState -> fabState = newState },
            fabState = fabState
        )
    }
}

@Composable
fun TweetList() {

}

@Composable
fun OpacityScreen(modifier: Modifier) {
    Box(modifier = modifier) {}
}

@Composable
fun ActionButton(
    modifier: Modifier,
    onStateChanged: (fabState: MultiFabState) -> Unit,
    fabState: MultiFabState
) {

    Column(modifier, horizontalAlignment = Alignment.End) {
        val transition = updateTransition(targetState = fabState, label = "fab_transitions")
        val rotation: Float by transition.animateFloat(label = "fab_rotation") { s: MultiFabState ->
            if (s == MultiFabState.EXPANDED) 45f else 0f
        }

        val scale: Float by transition.animateFloat { state ->
            if (state == MultiFabState.EXPANDED) 56f else 0f
        }

        val alpha: Float by transition.animateFloat(transitionSpec = {
            tween(durationMillis = 20)
        }, label = "") { state ->
            if (state == MultiFabState.EXPANDED) 1f else 0f
        }

        if (transition.currentState == MultiFabState.EXPANDED) {

            MultiFabItems.values().forEach {
                MiniFloatingActionButton(
                    item = it,
                    buttonScale = scale,
                    iconAlpha = alpha,
                    onFabItemClicked = {})
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        FloatingActionButton(
            modifier = modifier
                .padding(end = 12.dp, bottom = 10.dp)
                .rotate(rotation),
            onClick = {
                onStateChanged(
                    if (transition.currentState == MultiFabState.EXPANDED) {
                        MultiFabState.COLLAPSED
                    } else MultiFabState.EXPANDED
                )
            },
            backgroundColor = TwitterBlue
        ) {

            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }

}

@Composable
private fun MiniFloatingActionButton(
    item: MultiFabItems,
    buttonScale: Float,
    iconAlpha: Float,
    onFabItemClicked: (item: MultiFabItems) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 20.dp)
    ) {
        Text(
            item.label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .alpha(animateFloatAsState(iconAlpha).value)
                .padding(start = 2.dp, end = 3.dp, top = 4.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Surface(
            shape = CircleShape,
            border = BorderStroke(width = 1.dp, color = ButtonShadow),
            modifier = Modifier.size(40.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.White),
                onClick = { onFabItemClicked(item) }) {

                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = item.image,
                    contentDescription = null,
                    tint = TwitterBlue
                )
            }
        }
//        IconButton(
//            modifier = Modifier
//                .clip(CircleShape)
//                .background(color = Color.White)
//                .border(width = 2.dp, color = TwitterBlue),
//            onClick = { onFabItemClicked(item) }) {
//
//            Icon(
//                modifier = Modifier.size(30.dp),
//                imageVector =item.image,
//                contentDescription = null,
//                tint = TwitterBlue)
//        }
    }
}

@Preview(name = "Fab stack")
@Composable
fun PreviewFabStack() {
    Box(modifier = Modifier.fillMaxSize()) {
        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            onStateChanged = { },
            fabState = MultiFabState.EXPANDED
        )
    }
}


enum class MultiFabState {
    COLLAPSED, EXPANDED
}

enum class MultiFabItems(
    val identifier: String,
    val image: ImageVector,
    val label: String
) {

    SPACES("SPACES", Icons.Outlined.Info, "Spaces"),
    PHOTO("PHOTO", Icons.Outlined.Phone, "Photo"),
    GIF("GIF", Icons.Outlined.Build, "Gif")
}

private fun getListOfTweets(): List<TweetState> {
    val list = mutableListOf<TweetState>()
    val hoyneTweet1 = TweetState(twitterHandle = "@hoinzey", displayName = "Darren Hoyne", timeSinceTweet = "10h", content = "Hello world", 421, 18, 8)
    val hoyneTweet2 = TweetState(twitterHandle = "@hoinzey", displayName = "Darren Hoyne", timeSinceTweet = "10h", content = "There was some *awful* refereeing decisions today in the Premier league.\n" +
            "West Ham should have had a goal.\n" +
            "Newcastle should have had a goal.\n" +
            "Villa debatedly may have had a goal.", 1, 0, 2)
    val hoyneTweet3 = TweetState(twitterHandle = "@hoinzey", displayName = "Darren Hoyne", timeSinceTweet = "10h", content = "I can understand the children but these fully grown men begging for selfies with the hurlers after the game would wither you", 10005, 189, 23230)

    list.add(hoyneTweet1)
    list.add(hoyneTweet2)
    list.add(hoyneTweet3)

    return list
}


