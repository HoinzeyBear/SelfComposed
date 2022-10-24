package com.example.selfcomposed.imitations

data class TweetState(
    val twitterHandle: String,
    val displayName: String,
    val timeSinceTweet: String,
    val content: String,
    val commentCount: Int,
    val retweetCount: Int,
    val likeCount: Int
)
