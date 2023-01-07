package com.example.vehicleapp.presentation.screen.booking

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vehicleapp.R
import com.example.vehicleapp.presentation.components.AppBar
import com.example.vehicleapp.presentation.navigation.Screen

@Composable
fun BookingScreen(navController: NavController) {

    Scaffold(
        topBar = {
            AppBar(
                title = "Booking List",
                navController = navController
            ) {

                Spacer(modifier = Modifier.width(140.dp))

                Image(
                    painter = painterResource(id = R.drawable.qrcode),
                    contentDescription = "",
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(33.dp)
                        .clickable {
                            navController.navigate(Screen.ReceiptScreen.route)
                        }
                )
            }
        }
    ) {
        BookingListContent(modifier = Modifier.padding(it), navController = navController)
    }

}


@Composable
fun BookingListContent(modifier: Modifier, navController: NavController) {

    var search by remember { mutableStateOf("2") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text(text = "Search vehicle") },
                modifier = Modifier.weight(0.6f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Image(
                imageVector = Icons.Filled.Search,
                modifier = Modifier.size(44.dp),
                contentDescription = ""
            )
        }

        val searchList: Int? = search.toIntOrNull()

        LazyColumn {
            if (searchList != null) {
                items(searchList) {

                    VehicleDetailCard(onclick = {
                        navController.navigate(Screen.ReceiptScreen.route)
                    })
                }
            }
        }


    }
}

@Composable
fun VehicleDetailCard(onclick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable { onclick() },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.Black),
        backgroundColor = Color(0xCDBBBBBB)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(9.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.tuktuk),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )

            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Vehicle No. TN 01 BC 3402",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "In Time 8 : 53 PM",
                    fontSize = 16.sp
                )
                Text(
                    text = "Our Time 9 : 23 PM",
                    fontSize = 16.sp
                )
                Text(
                    text = "Price: ₹ 40.0",
                    fontSize = 16.sp
                )
                Text(
                    text = "Payment Method: __",
                    fontSize = 16.sp
                )
            }

            Image(
                painter = painterResource(id = R.drawable.motorbike),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )

        }
    }


}


@Preview(showBackground = true)
@Composable
fun Prevdffd() {
    BookingScreen(navController = rememberNavController())
}
