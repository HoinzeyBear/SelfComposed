@file:OptIn(ExperimentalFoundationApi::class)

package com.example.selfcomposed.workshop.viewpager

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ViewPagerCubeAnimation() {
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
            Box(modifier = Modifier.graphicsLayer {

            }){
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

// ACTUAL OFFSET
fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffsetFraction

// OFFSET ONLY FROM THE LEFT
fun PagerState.startOffsetForPage(page: Int): Float {
    return offsetForPage(page).coerceAtLeast(0f)
}

// OFFSET ONLY FROM THE RIGHT
fun PagerState.endOffsetForPage(page: Int): Float {
    return offsetForPage(page).coerceAtMost(0f)
}