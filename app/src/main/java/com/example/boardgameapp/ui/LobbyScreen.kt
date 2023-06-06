package com.example.boardgameapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.boardgameapp.R
import com.example.boardgameapp.data.GameUIState
import com.google.android.gms.nearby.connection.AdvertisingOptions

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


val STRATEGY = Strategy.P2P_STAR
val SERVICE_ID = "com.example.boardgameapp"

@Composable
fun LobbyScreen(
    uiState: GameUIState,
    modifier: Modifier = Modifier,
)  {
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

            /* Text(
                text = stringResource(uiState.gameName),
                style = MaterialTheme.typography.headlineMedium,
            ) */
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            Text(
                text = "Waiting Room",
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
    // Display way for players connect

    // Lobby box where player# is displayed

    // Cancel button (can lift from select options from cupcakes

    // Start Game button going to game screen
}
/* Nearby connections API
private fun startAdvertising() {
    val advertisingOptions: AdvertisingOptions = AdvertisingOptions.Builder().setStrategy(STRATEGY).build()
    Nearby.getConnectionsClient(context)
        .startAdvertising(
            getLocalUserName(), SERVICE_ID, connectionLifecycleCallback, advertisingOptions
        )
        .addOnSuccessListener { unused: Void? -> }
        .addOnFailureListener { e: Exception? -> }
} */