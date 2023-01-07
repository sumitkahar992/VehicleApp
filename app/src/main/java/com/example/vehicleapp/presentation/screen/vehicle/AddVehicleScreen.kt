package com.example.vehicleapp.presentation.screen.vehicle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vehicleapp.R
import com.example.vehicleapp.presentation.navigation.Screen


@Composable
fun AddVehicleScreen(navController: NavController) {

    Scaffold(
        topBar = {
            com.example.vehicleapp.presentation.components.AppBar(
                title = "Add Vehicle",
                navController = navController
            ) {}
        }
    ) {
        VehicleContent(modifier = Modifier.padding(it)) {
            navController.navigate(Screen.BookingScreen.route)
        }
    }

}


@Composable
fun VehicleContent(modifier: Modifier, onclick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        var vehicleNumber by remember { mutableStateOf("") }

        TextField(
            value = vehicleNumber,
            onValueChange = { vehicleNumber = it },
            label = { Text(text = "User vehicle no:") },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.vehicleno),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
        ) {

            Card(
                modifier = Modifier
                    .size(69.dp)
                    .background(Color.White, RectangleShape),
                elevation = 2.dp
//                contentAlignment = Alignment.TopCenter
            ) {
                Image(painter = painterResource(id = R.drawable.car), contentDescription = "")
            }

            Card(
                modifier = Modifier
                    .size(66.dp)
                    .background(Color.White, RectangleShape),
                elevation = 2.dp
            ) {
                Image(painter = painterResource(id = R.drawable.tuktuk), contentDescription = "")
            }

            Card(
                modifier = Modifier
                    .size(66.dp)
                    .background(Color.White, RectangleShape),
                elevation = 2.dp
            ) {
                Image(painter = painterResource(id = R.drawable.motorbike), contentDescription = "")
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .width(76.dp)
                    .height(33.dp)
                    .background(Color.White, RectangleShape),
                elevation = 2.dp
            ) {
                Text(text = "Monthly", textAlign = TextAlign.Center, fontSize = 18.sp)
            }
            Card(
                modifier = Modifier
                    .width(69.dp)
                    .height(28.dp)
                    .background(Color.White, RectangleShape),
                elevation = 2.dp
            ) {
                Text(text = "Weekly", textAlign = TextAlign.Center, fontSize = 18.sp)
            }
            Card(
                modifier = Modifier
                    .width(66.dp)
                    .height(33.dp)
                    .background(Color.White, RectangleShape),
                elevation = 2.dp
            ) {
                Text(text = "24 H", textAlign = TextAlign.Center, fontSize = 18.sp)
            }

        }

        Spacer(modifier = Modifier.height(33.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(43.dp)
                .padding(start = 33.dp, end = 33.dp)
                .background(Color.White, RectangleShape),
            elevation = 2.dp
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Price : ", fontSize = 22.sp)
                Text(text = " ₹ 0.0", fontSize = 22.sp, color = Color.Gray)
            }

        }

        Spacer(modifier = Modifier.height(33.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(43.dp)
                .padding(start = 39.dp, end = 39.dp)
                .background(Color(0xC9677CE0), RectangleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = " BHIMA ", fontSize = 21.sp)
        }

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xC9677CE0)),
            onClick = {
                onclick()
            }) {
            Text(text = "  BOOK  ", fontSize = 24.sp)
        }


    }


}


@Preview
@Composable
fun Prevvv() {
    AddVehicleScreen(navController = rememberNavController())
}
