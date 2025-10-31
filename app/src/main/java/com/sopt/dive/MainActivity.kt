package com.sopt.dive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.ui.theme.DiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiveTheme {
                BottomSection()
            }
        }
    }
}


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    nickname: String,
    greeting: String,
    userId: String,
    password: String,
    amount: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // 프로필 영역 (아바타 생략, 텍스트만)
        Text(text = nickname, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(6.dp))
        Text(text = greeting, fontSize = 16.sp, color = Color.Gray)

        Spacer(Modifier.height(28.dp))

        // ID
        Text(text = "ID", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(4.dp))
        Text(text = userId, fontSize = 16.sp, color = Color.Gray)

        Spacer(Modifier.height(24.dp))

        // PW
        Text(text = "PW", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(4.dp))
        Text(text = password, fontSize = 16.sp, color = Color.Gray)

        Spacer(Modifier.height(24.dp))

        // 주량
        Text(text = "주량", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(4.dp))
        Text(text = amount, fontSize = 16.sp, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    DiveTheme {
        MainScreen(
            nickname = "lesly",
            greeting = "안녕하세요",
            userId = "chanmi",
            password = "123456",
            amount = "0"
        )
    }
}
