package com.example.selfcomposed.imitations

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selfcomposed.R
import com.example.selfcomposed.ui.theme.SelfComposedTheme

@Composable
fun Tweet(tweetState: TweetState) {
    TweetContainer(tweetState)
}

@Composable
fun TweetContainer(
    tweetState: TweetState
) {
    Row(modifier = Modifier.border(1.dp, color = Color.LightGray)) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(top = 18.dp, start = 2.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.keycap_small),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color.Gray, CircleShape))
        }
        Spacer(modifier = Modifier.width(13.dp))
        Column(modifier = Modifier.fillMaxHeight()) {
            TopRow(displayName = tweetState.displayName, twitterHandle = tweetState.twitterHandle, timeSinceTweet = tweetState.timeSinceTweet)
            Content(content = tweetState.content)
            Spacer(modifier = Modifier.height(8.dp))
            BottomRow(commentCount = tweetState.commentCount, retweetCount = tweetState.retweetCount, likeCount = tweetState.likeCount)
        }
    }
}

@Composable
fun TopRow(
    modifier: Modifier = Modifier,
    displayName: String,
    twitterHandle: String,
    timeSinceTweet: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Row(horizontalArrangement = Arrangement.Start) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = displayName, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = twitterHandle, modifier = Modifier.alpha(0.8F))
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = timeSinceTweet, modifier = Modifier.alpha(0.8F))
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End) {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    content: String
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = content)
    }
}

@Composable
fun BottomRow(
    modifier: Modifier = Modifier,
    commentCount: Int,
    retweetCount: Int,
    likeCount: Int
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        BottomRowIconWithOptionalCount(count = commentCount, image = Icons.Outlined.Notifications)
        BottomRowIconWithOptionalCount(count = retweetCount, image = Icons.Outlined.Refresh)
        BottomRowIconWithOptionalCount(count = likeCount, image = Icons.Outlined.ThumbUp)
        BottomRowIconWithOptionalCount(count = 0, image = Icons.Outlined.Share)
        Spacer(modifier = Modifier.width(20.dp))
    }
}

@Composable
fun BottomRowIconWithOptionalCount(
    count: Int,
    image: ImageVector
) {
    Row(modifier = Modifier.clickable {  }) {
        Icon(imageVector = image, contentDescription = null, modifier = Modifier.alpha(0.7F))
        Spacer(modifier = Modifier.width(7.dp))
        if(count > 0) {
            Text(text = count.toString())
        }
    }
}





@Preview
@Composable
fun PreviewTweet() {
    val tweetState = TweetState(twitterHandle = "@hoinzey", displayName = "Darren Hoyne", timeSinceTweet = "10h", content = "Hello world", 421, 18, 8)
    SelfComposedTheme {
        Tweet(tweetState)
    }
}

@Preview
@Composable
fun PreviewBottomRow() {
    SelfComposedTheme {
        BottomRow(commentCount = 2, retweetCount = 1, likeCount = 8)
    }
}