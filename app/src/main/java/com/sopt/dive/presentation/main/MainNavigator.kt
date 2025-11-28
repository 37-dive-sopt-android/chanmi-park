package com.sopt.dive.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.dive.presentation.home.Home
import com.sopt.dive.presentation.home.navigateToHome
import com.sopt.dive.presentation.mypage.navigateToMypage
import com.sopt.dive.presentation.search.navigateToSearch


//Navigator: Controller를 포함하고 있음 / 화면 이동을 담당하는 클래스
class MainNavigator(
    val navController: NavHostController, // 실제 화면 이동을 담당하는 NavController
){
    val startDestination = Home

    //현재 어떤 화면에 있는지 알아내기 위한 변수
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value?.destination

    //현재 어떤 탭에 있는지 찾아내는 변수
    val currentTab: MainNavTab?
        @Composable get() = MainNavTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    fun navigate(tab : MainNavTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainNavTab.HOME -> navController.navigateToHome(navOptions)
            MainNavTab.SEARCH -> navController.navigateToSearch(navOptions)
            MainNavTab.MYPAGE -> navController.navigateToMypage(navOptions)
        }
    }
    @Composable
    fun showBottomNavigator() = MainNavTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}