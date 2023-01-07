package com.example.vehicleapp.presentation.navigation

sealed class Screen(val route: String) {

    object LoginScreen : Screen("login_screen")
    object AddVehicleScreen : Screen("add_vehicle_screen")
    object BookingScreen : Screen("book_screen")
    object ReceiptScreen : Screen("receipt_screen")


}
