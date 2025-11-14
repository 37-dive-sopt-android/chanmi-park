package com.sopt.dive.presentation.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.dive.navigation.MainTabRoute
import com.sopt.dive.presentation.mypage.MypageRoute
import kotlinx.serialization.Serializable


fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    navigate(Search, navOptions)
}


fun NavGraphBuilder.searchGrap(
    padding: PaddingValues
) {
    composable<Search> {
        SearchRoute(padding)
    }
}

@Serializable
data object Search : MainTabRoute
