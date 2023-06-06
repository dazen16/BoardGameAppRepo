package com.example.boardgameapp.ui

import androidx.lifecycle.ViewModel
import com.example.boardgameapp.data.GameUIState
// import com.example.boardgameapp.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState())
    val uiState: StateFlow<GameUIState> = _uiState.asStateFlow()

    fun setGame(gameSelected : Int) {
        _uiState.update { currentState ->
            currentState.copy(
                gameName = gameSelected,
            )
        }
    }

    fun setGameID(gameID: String) {
        _uiState.update { currentState ->
            currentState.copy(
                gameID = gameID,
            )
        }
    }
    /*
        /**
         * Set the quantity [numberCupcakes] of cupcakes for this order's state and update the price
         */
        fun setQuantity(numberCupcakes: Int) {
            _uiState.update { currentState ->
                currentState.copy(
                    quantity = numberCupcakes,
                    price = calculatePrice(quantity = numberCupcakes)
                )
            }
        }

        /**
         * Set the [desiredFlavor] of cupcakes for this order's state.
         * Only 1 flavor can be selected for the whole order.
         */
        fun setFlavor(desiredFlavor: String) {
            _uiState.update { currentState ->
                currentState.copy(flavor = desiredFlavor)
            }
        }

        /**
         * Set the [pickupDate] for this order's state and update the price
         */
        fun setDate(pickupDate: String) {
            _uiState.update { currentState ->
                currentState.copy(
                    date = pickupDate,
                    price = calculatePrice(pickupDate = pickupDate)
                )
            }
        }

        /**
         * Reset the order state
         */
        fun resetOrder() {
            _uiState.value = OrderUiState(pickupOptions = pickupOptions())
        }

        /**
         * Returns the calculated price based on the order details.
         */
        private fun calculatePrice(
            quantity: Int = _uiState.value.quantity,
            pickupDate: String = _uiState.value.date
        ): String {
            var calculatedPrice = quantity * PRICE_PER_CUPCAKE
            // If the user selected the first option (today) for pickup, add the surcharge
            if (pickupOptions()[0] == pickupDate) {
                calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
            }
            val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
            return formattedPrice
        }

        /**
         * Returns a list of date options starting with the current date and the following 3 dates.
         */
        private fun pickupOptions(): List<String> {
            val dateOptions = mutableListOf<String>()
            val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
            val calendar = Calendar.getInstance()
            // add current date and the following 3 dates.
            repeat(4) {
                dateOptions.add(formatter.format(calendar.time))
                calendar.add(Calendar.DATE, 1)
            }
            return dateOptions
        }
      */
}
