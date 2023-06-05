package com.example.boardgameapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.boardgameapp.data.GameUIState

@Composable
fun LobbyScreen(
    uiState: GameUIState,
    modifier: Modifier = Modifier,
)  {
    // Text("Lobby Screen test")
    Text(
        text = stringResource(uiState.gameName),
    )
    // Display way for players connect

    // Lobby box where player# is displayed

    // Cancel button (can lift from select options from cupcakes

    // Start Game button going to game screen
}