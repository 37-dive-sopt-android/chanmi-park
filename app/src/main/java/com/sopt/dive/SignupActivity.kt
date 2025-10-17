package com.sopt.dive

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.ui.theme.DiveTheme


class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                SignupScreen(
                )
            }
        }
    }
}

fun isValidId(id: String) = id.length in 6..10
fun isValidPassword(password: String) = password.length in 8..12
fun isValidNickname(nickname: String) = nickname.isNotBlank() && nickname.trim().isNotEmpty()

@Composable
fun SignupHeaderSection() {
    var text by remember { mutableStateOf("") }

    Text(
        text = "Sign Up",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SignupFieldSection(
    id: String,
    onIdChange: (String) -> Unit,
    idError: Boolean,
    pw: String,
    onPwChange: (String) -> Unit,
    pwError: Boolean,
    nick: String,
    onNickChange: (String) -> Unit,
    nickError: Boolean,
    mbti: String,
    onMbtiChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ){
        //회원가입 - 아이디 입력란
        Text(
            text = "ID",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
        )
        TextField(
            value = id,
            onValueChange = onIdChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text("사용자 이름 입력") },
            singleLine = true,
            isError = idError,
            supportingText = { if (idError) Text("ID는 6~10자이어야 합니다.") }
        )
        //회원가입 - 비밀번호 입력란
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
            value = pw,
            onValueChange = onPwChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text("비밀번호 입력") },
            singleLine = true,
            isError = pwError,
            supportingText = { if (pwError) Text("비밀번호는 8~12자이어야 합니다.") },
            visualTransformation = PasswordVisualTransformation()
        )
        //회원가입 - 닉네임 입력란
        Text(
            text = "NICKNAME",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable(onClick = {})
                .padding(start = 10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = nick,
            onValueChange = onNickChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text("닉네임 입력") },
            singleLine = true,
            isError = nickError,
            supportingText = { if (nickError) Text("공백만 불가, 한 글자 이상 입력") }
        )
        //회원가입 - MBTI 입력란
        Text(
            text = "MBTI",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable(onClick = {})
                .padding(start = 10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = mbti,
            onValueChange = onMbtiChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text("MBTI 입력") },
            singleLine = true
        )

    }
}

@Composable
fun SignupButtonSection(onSignUp: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Bottom) {
        Button(
            onClick = onSignUp,
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
            shape = RoundedCornerShape(8.dp)
        ) { Text("Sign up") }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreen() {
    val activity = LocalContext.current

    var idtext by remember { mutableStateOf("") }
    var pwtext by remember { mutableStateOf("") }
    var nicktext by remember { mutableStateOf("") }
    var mbtitext by remember { mutableStateOf("") }

    val idError = idtext.isNotEmpty() && !isValidId(idtext)
    val pwError = pwtext.isNotEmpty() && !isValidPassword(pwtext)
    val nickError = nicktext.isNotEmpty() && !isValidNickname(nicktext)

    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        SignupHeaderSection()
        SignupFieldSection(
            id = idtext,
            onIdChange = { idtext = it },
            idError = idError,
            pw = pwtext,
            onPwChange = { pwtext = it },
            pwError = pwError,
            nick = nicktext,
            onNickChange = { nicktext = it },
            nickError = nickError,
            mbti = mbtitext,
            onMbtiChange = { mbtitext = it }
        )
        SignupButtonSection(
            onSignUp = {
                val oka = isValidId(idtext) && isValidPassword(pwtext) && isValidNickname(nicktext)
                if (oka) {
                    val result = Intent().apply {
                        putExtra("id", idtext)
                        putExtra("pw", pwtext)
                        putExtra("nick", nicktext)
                        putExtra("mbti", mbtitext)
                    }
                    (activity as? Activity)?.let {
                        it.setResult(Activity.RESULT_OK, result)
                        it.finish()
                    }
                } else {
                    Toast.makeText(activity, "입력값을 확인하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}