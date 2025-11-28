package com.sopt.dive.presentation.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.Server.ui.theme.DiveTheme

@Composable
fun HeaderScreen(
    title: String,
    modifier: Modifier = Modifier
){
    //Box가 있는 이유 : 아이콘이 왼쪽이 있을수도 있고 없을수도 있고, 오른쪽에 있을수도 있고 없을수도 있고.... 등등 겹쳐질 수 있는 부분이 있으므로 Box로 설정 (Row로 바로 설정 X)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp, vertical = 12.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center

    ){
        Text(
            text = title,
            modifier = Modifier,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    DiveTheme {
         HeaderScreen("박찬미")
     }
}