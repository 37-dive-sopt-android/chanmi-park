package com.sopt.dive.presentation.mypage

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.dive.navigation.MainTabRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToMypage(navOptions: NavOptions? = null) {
    navigate(Mypage, navOptions)
}


fun NavGraphBuilder.myPageGrap(
    padding: PaddingValues
) {
    composable<Mypage> {
        MypageRoute(padding)
    }
}

@Serializable
data object Mypage : MainTabRoute