package com.example.vehicleapp.presentation.screen.vehicle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.vehicleapp.presentation.components.AppBar
import com.example.vehicleapp.presentation.navigation.Screen


@Composable
fun AddVehicleScreen(navController: NavController) {

    Scaffold(
        topBar = {
            AppBar(
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
        modifier = modifier
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

        Row {
            VehicleCard(text = "Monthly", image = R.drawable.car)
            VehicleCard(text = "Weekly", image = R.drawable.tuktuk)
            VehicleCard(text = " 24 H", image = R.drawable.motorbike)
        }


        Spacer(modifier = Modifier.height(33.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(43.dp)
                .padding(start = 33.dp, end = 33.dp)
                .background(Color.White, RectangleShape)
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

@Composable
fun VehicleCard(text: String, image: Int) {

    Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Card(
            modifier = Modifier
                .size(69.dp)
                .background(Color.White, RectangleShape)
//                contentAlignment = Alignment.TopCenter
        ) {
            Image(
                modifier = Modifier.padding(8.dp),
                painter = painterResource(id = image),
                contentDescription = ""
            )
        }

        Card(
            modifier = Modifier
                .width(76.dp)
                .height(33.dp)
                .background(Color.White, RectangleShape)
        ) {
            Text(text = text, textAlign = TextAlign.Center, fontSize = 18.sp)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun VehicleCardPrev() {
    VehicleCard(text = "Monthly", image = R.drawable.motorbike)
}

@Preview
@Composable
fun AddVehicleScreenPreview() {
    AddVehicleScreen(navController = rememberNavController())
}
