package com.sopt.dive.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.sopt.dive.presentation.home.homeGrap
import com.sopt.dive.presentation.mypage.myPageGrap
import com.sopt.dive.presentation.search.searchGrap

//Host : 모든 경로는 이곳에 포함되어있어야됨
@Composable
fun MainNavHost(
    navigator: MainNavigator,
    paddingValues: PaddingValues, // 이건 왜 설정하는건지
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
        modifier = modifier
    ){

        homeGrap(paddingValues)
        searchGrap(paddingValues)
        myPageGrap(paddingValues)

    }
}