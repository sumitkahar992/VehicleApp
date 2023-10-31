package com.example.vehicleapp.presentation.screen.booking

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        modifier = Modifier.padding(12.dp),
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
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            value = search,
            onValueChange = { search = it },
            label = { Text(text = "Search vehicle") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Image(
                    imageVector = Icons.Filled.Search,
                    modifier = Modifier.size(34.dp),
                    contentDescription = ""
                )
            }
        )


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
        colors = CardDefaults.cardColors(containerColor = Color(0xCDBBBBBB))
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
