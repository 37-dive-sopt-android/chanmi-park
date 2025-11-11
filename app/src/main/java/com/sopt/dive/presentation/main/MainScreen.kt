package com.sopt.dive.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sopt.dive.BottomSection
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {
            if (navigator.showBottomNavigator()) {
                BottomSection(
                    modifier = Modifier,
                    tabs = MainNavTab.entries.toPersistentList(),
                    currentTab = navigator.currentTab,
                    onTabSelected = navigator::navigate
                )
            }
        }
    ) { padding ->
        MainNavHost(
            navigator = navigator,
            padding = padding,
            modifier = Modifier
        )
    }
}