package com.example.boardgameapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.boardgameapp.R
import com.example.boardgameapp.data.GameUIState

@Composable
fun JoinGameScreen(
    uiState: GameUIState,
    onJoin: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            Text(
                text = "Join a Game",
                style = MaterialTheme.typography.headlineSmall,
            )

            val gameID = EnterGameCode(modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

            // Text(gameID)

            // viewModel.setGame(it)

            Button(
                modifier = Modifier.weight(1f),
                onClick = onJoin
            ) {
                Text(stringResource(R.string.join))
            }


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterGameCode(modifier: Modifier = Modifier): String {
    var gameID by remember { mutableStateOf("") }

    TextField(
        value = gameID,
        onValueChange = { gameID = it },
        modifier = modifier,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(stringResource(R.string.enterID)) }
    )

    return gameID
}