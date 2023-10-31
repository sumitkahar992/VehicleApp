package com.example.vehicleapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vehicleapp.presentation.screen.booking.BookingScreen
import com.example.vehicleapp.presentation.screen.login.LoginScreen
import com.example.vehicleapp.presentation.screen.receipt.ReceiptScreen
import com.example.vehicleapp.presentation.screen.vehicle.AddVehicleScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(route = Screen.AddVehicleScreen.route) {
            AddVehicleScreen(navController)
        }

        composable(route = Screen.BookingScreen.route) {
            BookingScreen(navController)
        }

        composable(route = Screen.ReceiptScreen.route) {
            ReceiptScreen(navController)
        }


    }


}