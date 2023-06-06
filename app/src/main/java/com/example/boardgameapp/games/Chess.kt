package com.example.boardgameapp.games

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boardgameapp.data.GameUIState

@Composable
fun Chess(uiState: GameUIState, returnToMainScreen: () -> Unit) {
    val board = remember {
        mutableStateOf(Array(8) { arrayOfNulls<String>(8) })
    }

    val currentPlayer = remember {
        mutableStateOf(1) // 1 = White
    }

    val winner = remember {
        mutableStateOf<String?>(null)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        // .background()
        .padding(16.dp)) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(uiState.gameName),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }
}