package com.sopt.dive.presentation.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.presentation.home.HomeScreen
import com.sopt.dive.presentation.main.MainNavTab
import com.sopt.dive.presentation.mypage.MypageScreen
import com.sopt.dive.presentation.search.SearchScreen
import kotlinx.collections.immutable.ImmutableList
import androidx.compose.ui.graphics.Color
import com.sopt.dive.core.util.noRippleClickable
import kotlinx.collections.immutable.toImmutableList


@Composable
fun MainButtonBar(
    tabs: ImmutableList<MainNavTab>,
    currentTab: MainNavTab?,
    onTabSelected: (MainNavTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 5.dp)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        tabs.forEach { tab ->
            MainNavigationBarItem(
                selected = tab == currentTab,
                tab = tab,
                onClick = { onTabSelected(tab) },
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 12.dp),
            )
        }
    }
}

@Composable
private fun MainNavigationBarItem(
    selected: Boolean,
    tab: MainNavTab,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomBarColor = if (selected) Color.Red else Color.LightGray

    Column(
        modifier = modifier
            .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = tab.icon),
            contentDescription = tab.contentDescription,
            tint = bottomBarColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomActivityPreview() {
    var currentTab by remember { mutableStateOf(null) }
    MainButtonBar(
        tabs = MainNavTab.entries.toImmutableList(),
        currentTab = currentTab,
        onTabSelected = { }
    )
}
