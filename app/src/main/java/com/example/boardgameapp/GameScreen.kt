package com.example.boardgameapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.boardgameapp.ui.BoardGameScreen
import com.example.boardgameapp.ui.GameViewModel
import com.example.boardgameapp.ui.JoinGameScreen
import com.example.boardgameapp.ui.LobbyScreen
import com.example.boardgameapp.ui.SelectDevicesScreen
import com.example.boardgameapp.ui.theme.MainMenuScreen


enum class GameScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Devices(title = R.string.devices),
    Lobby(title = R.string.lobby),
    Join(title = R.string.join),
    Game(title = R.string.game),
    Completion(title = R.string.completion),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(
    currentScreen: GameScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {  }, // Text(stringResource(currentScreen.title))
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoardGameApp(
    viewModel: GameViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = GameScreen.valueOf(
        backStackEntry?.destination?.route ?: GameScreen.Start.name
    )

    Scaffold(
        topBar = {
            AppHeader(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        // Text(text = "Test")

        NavHost(
            navController = navController,
            startDestination = GameScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Main Menu
            composable(route = GameScreen.Start.name) {
                MainMenuScreen(
                    // quantityOptions = DataSource.quantityOptions,
                    onGameSelected = {
                        viewModel.setGame(it)
                        navController.navigate(GameScreen.Devices.name)
                    },
                    joinGame = {
                        navController.navigate(GameScreen.Join.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

            // Select Devices Screen
            composable(route = GameScreen.Devices.name) {
                SelectDevicesScreen(
                    uiState,
                    onOneDeviceButtonClicked = { navController.navigate(GameScreen.Game.name) },
                    onMultiDeviceButtonClicked = { navController.navigate(GameScreen.Lobby.name) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            // Lobby Screen
            composable(route = GameScreen.Lobby.name) {
                LobbyScreen(
                    uiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            // Join Game Screen
            composable(route = GameScreen.Join.name) {
                JoinGameScreen(
                    uiState,
                    onJoin = { navController.navigate(GameScreen.Lobby.name) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            // Game Screen
            composable(route = GameScreen.Game.name) {
                BoardGameScreen(
                    uiState,
                    returnToMainScreen = { navController.navigate(GameScreen.Start.name) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            // Completion Screen
        }


    }
}