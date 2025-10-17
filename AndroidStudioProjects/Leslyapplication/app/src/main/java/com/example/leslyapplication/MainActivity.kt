package com.example.leslyapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leslyapplication.ui.theme.IntentActivity
import com.example.leslyapplication.ui.theme.LeslyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeslyApplicationTheme {
                ColumnPreview(

               )
            }
        }
    }
}
/*
fun GreetingPreview(){

}
*/

@Composable
fun HeaderSection() {
    var text by remember { mutableStateOf("") }

    Text(
        text = "Welcome To Sopt",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun FieldSection() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ){
        //로그인 - 아이디 입력란
        Text(
            text = "ID",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text("사용자 이름 입력") },
            singleLine = true
        )
        //로그인 - 비밀번호 입력란
        Text(
            text = "PW",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable(onClick = {})
                .padding(start = 10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text("비밀번호 입력") },
            singleLine = true
        )
    }
}

@Composable
fun ButtonSection() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        //로그인 버튼
        Button(
            onClick = { /* 클릭 시 수행될 동작 */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Login"
            )
        }

        //회원가입 버튼
        Button(
            onClick = {
                val intent = Intent(context, SignupActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Sign up"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderSection()
        FieldSection()
        ButtonSection()
    }
}




