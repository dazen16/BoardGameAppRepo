package com.example.boardgameapp.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.boardgameapp.R
import com.example.boardgameapp.data.GameUIState
import com.example.boardgameapp.games.Chess
import com.example.boardgameapp.games.TicTacToe

@Composable
fun BoardGameScreen(
    uiState: GameUIState,
    returnToMainScreen: () -> Unit = {},
    modifier: Modifier = Modifier,
)  {
    if (uiState.gameName == R.string.tictactoe)
        TicTacToe(uiState = uiState, returnToMainScreen = returnToMainScreen)
    else if (uiState.gameName == R.string.chess)
        Chess(uiState = uiState, returnToMainScreen = returnToMainScreen)
}