package com.sopt.dive.presentation.main

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.sopt.dive.presentation.home.Home
import com.sopt.dive.R
import com.sopt.dive.navigation.MainTabRoute
import com.sopt.dive.presentation.mypage.Mypage
import com.sopt.dive.presentation.search.Search

enum class MainNavTab(
    @DrawableRes val icon: Int,
    val contentDescription: String,
    val route: MainTabRoute
){
    HOME(
        icon = R.drawable.ic_home,
        contentDescription = "home",
        route = Home
    ),

    SEARCH(
        icon = R.drawable.ic_search,
        contentDescription = "search",
        route = Search
    ),

    MYPAGE(
        icon = R.drawable.ic_mypage,
        contentDescription = "mypage",
        route = Mypage
    );


    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainNavTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}