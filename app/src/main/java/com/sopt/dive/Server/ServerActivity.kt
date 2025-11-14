package com.sopt.dive.Server

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.dive.Server.ServicePool
import com.sopt.dive.Server.ui.theme.DiveTheme
import com.sopt.dive.data.dto.response.ResponseSingleUserDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServerActivity : ComponentActivity() {

    private val userService by lazy { ServicePool.userService }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val userState = remember { mutableStateOf<ResponseSingleUserDto?>(null) }
            val isLoading = remember { mutableStateOf(false) }
            val errorMessage = remember { mutableStateOf<String?>(null) }

            LaunchedEffect(Unit) {
                getSingleUser(
                    id = 2,
                    userState = userState,
                    isLoading = isLoading,
                    errorMessage = errorMessage
                )
            }

            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        when {
                            isLoading.value -> CircularProgressIndicator()

                            errorMessage.value != null -> Text(
                                text = "Error: ${errorMessage.value}",
                                color = MaterialTheme.colorScheme.error
                            )

                            userState.value != null -> UserProfile(userState.value!!)
                        }
                    }
                }
            }
        }
    }

    private fun getSingleUser(
        id: Int,
        userState: MutableState<ResponseSingleUserDto?>,
        isLoading: MutableState<Boolean>,
        errorMessage: MutableState<String?>
    ) {
        isLoading.value = true

        userService.getSingleUser(id)
            .enqueue(object : Callback<ResponseSingleUserDto> {
                override fun onResponse(
                    call: Call<ResponseSingleUserDto>,
                    response: Response<ResponseSingleUserDto>
                ) {
                    isLoading.value = false
                    if (response.isSuccessful) {
                        userState.value = response.body()
                        Log.d("ServerActivity", "user loaded: ${userState.value}")
                    } else {
                        errorMessage.value = response.message()
                        Log.e("ServerActivity", "Error: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ResponseSingleUserDto>, t: Throwable) {
                    isLoading.value = false
                    errorMessage.value = t.message
                    Log.e("ServerActivity", "Failure: ${t.message}")
                }
            })
    }
}

@Composable
fun UserProfile(user: ResponseSingleUserDto) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "ID: ${user.id}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Username: ${user.username}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Age: ${user.age}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Status: ${user.status}", style = MaterialTheme.typography.bodyLarge)
    }
}
