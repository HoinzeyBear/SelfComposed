package com.example.selfcomposed.workshop.viewpager

sealed class Page {
    object Feed: Page()
    object Profile : Page()
    object Search : Page()
    object Settings: Page()
}

val pages = listOf(
    Page.Feed, Page.Profile, Page.Search, Page.Settings
)
