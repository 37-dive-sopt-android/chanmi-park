package com.sopt.dive.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.dive.navigation.MainTabRoute
import kotlinx.serialization.Serializable


fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(Home, navOptions)
}


fun NavGraphBuilder.homeGrap(
    padding: PaddingValues
) {
    composable<Home> {
        HomeRoute(padding)
    }
}

@Serializable
data object Home : MainTabRoute
