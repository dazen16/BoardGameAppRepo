package com.example.boardgameapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.boardgameapp.R
import com.example.boardgameapp.data.GameUIState

@Composable
fun SelectDevicesScreen(
    uiState: GameUIState,
    onOneDeviceButtonClicked: () -> Unit = {},
    onMultiDeviceButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    val curGame = uiState.gameName

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
            Text(
                text = stringResource(curGame),
                style = MaterialTheme.typography.headlineMedium,
            )
            Spacer(modifier = Modifier.height(200.dp))

            Text(
                text = "How many devices do you want to play on?",
                style = MaterialTheme.typography.bodyLarge,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    // .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Top // Bottom
            ){
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onOneDeviceButtonClicked
                ) {
                    Text(stringResource(R.string.onedevice))
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onMultiDeviceButtonClicked
                ) {
                    Text(stringResource(R.string.multidevice))
                }
            }
        }

    }
}