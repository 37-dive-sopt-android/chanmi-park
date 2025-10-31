package com.sopt.dive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.ui.theme.DiveTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Chat(val name: String, val content: String)

val sampleChats = listOf(
    Chat("박동민", "지금은 금요일 저녁 10시"),
    Chat("동민", "버락치기 힘들다"),
    Chat("민", "다음주엔 미리해야지"),
    Chat("송혜윰", "히히 안드 재밌다"),
    Chat("이석준", "솔직히 내가 리드실력임 ㅋㅋ"),
    Chat("박유진", "으앙 어려워요"),
    Chat("더미", "더미더미"),
    Chat("더미", "더미더미"),
    Chat("더미", "더미더미")
)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
//        items(sampleChats) { chat ->   // ← 리스트 이름 맞춤
//            Column(modifier = Modifier.fillMaxWidth()) {
//                Text(text = chat.name, fontSize = 16.sp)
//                Text(text = chat.content, fontSize = 14.sp)
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiveTheme {
        HomeScreen()
    }
}