@file:OptIn(ExperimentalFoundationApi::class)

package com.example.selfcomposed.workshop.viewpager

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ViewPagerDemo() {
    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState()
        val showButton = remember {
            derivedStateOf {
                pagerState.currentPage != 0
            }
        }

        HorizontalPager(
            pageCount = pages.size,
            state = pagerState) { pageIndex ->

            when(pages[pageIndex]) {
                Page.Feed -> FeedPage()
                Page.Profile -> ProfilePage()
                Page.Search -> SearchPage()
                Page.Settings -> SettingsPage()
            }

            val scope = rememberCoroutineScope()
            Box{
                this@Column.AnimatedVisibility(
                    visible = showButton.value,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomStart),
                    enter = slideInVertically { it } + fadeIn(),
                    exit = slideOutVertically { it } + fadeOut(),
                ) {
                    Button(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(0)
                            }
                        },
                    ) {
                        Text(text = "Scroll to start")
                    }
                }
            }
        }
    }
}

@Composable
fun FeedPage() {
    Box(modifier = Modifier
        .padding(20.dp)
        .background(Color.Yellow.copy(alpha = 0.6F))
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.List, contentDescription = null)
    }

}

@Composable
fun ProfilePage() {
    Box(modifier = Modifier
        .padding(20.dp)
        .background(Color.Blue.copy(alpha = 0.6F))
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Person, contentDescription = null)
    }
}

@Composable
fun SearchPage() {
    Box(modifier = Modifier
        .padding(20.dp)
        .background(Color.Red.copy(alpha = 0.6F))
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Search, contentDescription = null)
    }
}

@Composable
fun SettingsPage() {
    Box(modifier = Modifier
        .padding(20.dp)
        .background(Color.Green.copy(alpha = 0.6F))
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Icon(modifier = Modifier.size(40.dp), imageVector = Icons.Default.Settings, contentDescription = null)
    }
}