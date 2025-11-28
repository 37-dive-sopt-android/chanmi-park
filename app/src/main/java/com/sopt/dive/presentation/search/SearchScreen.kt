package com.sopt.dive.presentation.search

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.R
import com.sopt.dive.ui.theme.DiveTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@Composable
fun SearchRoute(
    paddingValues: PaddingValues,
) {
    SearchScreen(paddingValues)
}

enum class CardState { front, back }

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    var currentState by remember { mutableStateOf(CardState.back) }

    val clickCountFlow = remember { MutableStateFlow(0) }
    val clickCount by clickCountFlow.collectAsState()

    val scope = rememberCoroutineScope()

    val animateFloat by animateFloatAsState(
        targetValue = when(currentState) {
            CardState.front -> 180f
            CardState.back -> 0f
        }
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        animationImage(
            animation = animateFloat,
            currentState = currentState
        )

        Spacer(modifier = Modifier.height(40.dp))

        animationButton(
            onClick = {
                scope.launch {
                    //코루틴 여기 적용했어요
                    kotlinx.coroutines.delay(300)
                    currentState =
                        if (currentState == CardState.back) CardState.front
                        else CardState.back
                    //flow 여기 적용했어요
                    clickCountFlow.update { it + 1 }
                }

            },
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "버튼 클릭 횟수: $clickCount")
    }
}
@Composable
private fun animationImage(
    animation: Float,
    currentState: CardState,
    modifier: Modifier = Modifier
){

    val currentImage =
        if (currentState == CardState.back) R.drawable.img_playingcard_back
        else R.drawable.img_playingcard_front

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        Image(
            painter = painterResource(currentImage),
            contentDescription = "플레잉카드",
            modifier = Modifier
                .fillMaxWidth()
                .rotate(animation),
            contentScale = ContentScale.Crop,
        )
    }
}


@Composable
private fun animationButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        Text(
            text = "Click Here!"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    DiveTheme {
        SearchScreen(paddingValues = PaddingValues())
    }
}