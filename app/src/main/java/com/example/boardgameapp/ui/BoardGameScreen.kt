package com.example.boardgameapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boardgameapp.data.GameUIState

@Composable
fun BoardGameScreen(
    uiState: GameUIState,
    returnToMainScreen: () -> Unit = {},
    modifier: Modifier = Modifier,
)  {
    TicTacToe(uiState = uiState, returnToMainScreen = returnToMainScreen)
}

@Composable
fun TicTacToe(
    uiState: GameUIState,
    returnToMainScreen: () -> Unit = {},
) {
    val board = remember {
        mutableStateOf(Array(3) { arrayOfNulls<String>(3) })
    }

    val currentPlayer = remember {
        mutableStateOf(1) // 1 = X
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
                text = stringResource(uiState.gameName), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 30.sp
            )
        }

        Text(text = "Player 1 = 'X'\nPlayer 2 = 'O'\nCurrent Player: ${currentPlayer.value}", modifier = Modifier.padding(top = 16.dp))

        Box(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()) {
            Column() {
                for (row in 0  ..  2) {
                    Row {
                        for (col in 0 .. 2) {
                            Button(modifier = Modifier
                                .weight(1f)
                                .padding(4.dp),
                                onClick = { onGridClick(row, col, board, currentPlayer, winner.value) }) {
                                Text(text = board.value[row][col] ?: "", color = Color.White)

                                winner.value = checkTicTacToeWinner(board)
                            }
                        }
                    }
                }

                if (winner.value != null) {
                    Text(text = if (winner.value != "draw") "Winner: Player ${winner.value}!" else "Draw",
                        modifier = Modifier.padding(4.dp),
                        textAlign = TextAlign.Center)
                    Button(onClick = { returnToMainScreen }) {
                        Text(text = "Main Menu")
                    }
                }
            }
        }
    }
}

fun onGridClick(row : Int,
                col: Int,
                board: MutableState<Array<Array<String?>>>,
                curPlayer: MutableState<Int>,
                winner: String?,
) {
    if (board.value[row][col] == null && winner == null) {
        board.value[row][col] = if (curPlayer.value == 1) "X" else "O"
        curPlayer.value = if (curPlayer.value == 1) 2 else 1
    }
}

fun checkTicTacToeWinner(board: MutableState<Array<Array<String?>>>): String? {
    // Checking if any rows are done
    for (row in 0 .. 2) {
        val rowVal = board.value[row][0]
        if (rowVal != null && rowVal == board.value[row][1] && rowVal == board.value[row][2]) {
            return rowVal
        }
    }

    // Checking if any cols are done
    for (col in 0 .. 2) {
        val colVal = board.value[col][0]
        if (colVal != null && colVal == board.value[col][1] && colVal == board.value[col][2]) {
            return colVal
        }
    }

    // Diagonal
    if (board.value[0][0] != null && board.value[0][0] == board.value[1][1] && board.value[0][0] == board.value[2][2]) {
        return board.value[0][0]
    }

    // Diagonal
    if (board.value[0][2] != null && board.value[0][2] == board.value[1][1] && board.value[0][0] == board.value[2][0]) {
        return board.value[0][2]
    }

    // Checking for a draw
    for (row in 0 .. 2) {
        for (col in 0 .. 2) {
            if (board.value[row][col] == null) {
                return null
            }
        }
    }

    return "draw"
}