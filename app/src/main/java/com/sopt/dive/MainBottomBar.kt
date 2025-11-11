package com.sopt.dive

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.dive.presentation.home.HomeScreen
import com.sopt.dive.presentation.mypage.MypageScreen
import com.sopt.dive.presentation.search.SearchScreen

enum class BottomTab {
    HOME, SEARCH, MY
}
@Composable
fun BottomSection() {
    var selectedTab by remember { mutableStateOf(BottomTab.HOME) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == BottomTab.HOME,
                    onClick = { selectedTab = BottomTab.HOME },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedTab == BottomTab.SEARCH,
                    onClick = { selectedTab = BottomTab.SEARCH },
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                    label = { Text("Search") }
                )
                NavigationBarItem(
                    selected = selectedTab == BottomTab.MY,
                    onClick = { selectedTab = BottomTab.MY },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "My") },
                    label = { Text("My") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (selectedTab) {
                BottomTab.HOME -> HomeScreen()
                BottomTab.SEARCH -> SearchScreen()
                BottomTab.MY -> MypageScreen(
                    nickname = "lesly",
                    greeting = "안녕하세요",
                    userId = "chanmi",
                    password = "123456",
                    amount = "0"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomActivityPreview() {
    BottomSection()
}
