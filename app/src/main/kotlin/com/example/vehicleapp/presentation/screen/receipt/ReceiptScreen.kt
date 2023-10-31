package com.example.vehicleapp.presentation.screen.receipt

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vehicleapp.R
import com.example.vehicleapp.presentation.components.AppBar

@Composable
fun ReceiptScreen(navController: NavController) {

    Scaffold(
        topBar = {
            AppBar(
                title = "User Receipt",
                navController = navController
            ) {}
        }
    ) {
        ReceiptListContent(modifier = Modifier.padding(it))
    }

}


@Composable
fun ReceiptListContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(160.dp)
                .background(Color.White, RectangleShape)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = "",
                    contentScale = ContentScale.Inside
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Column {
            TextComponents(left = "Vehicle No.", right = "KA03AC6315")
            TextComponents(left = "In Time ", right = "15/09/2021  1:26 PM")
            TextComponents(left = "Exp Out Time", right = "15/09/2021  1:26 PM")
            TextComponents(left = "Amount Paid", right = "Rs. 50")
        }



        Spacer(modifier = Modifier.height(22.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(43.dp)
                .padding(start = 39.dp, end = 39.dp)
                .background(Color(0xC9677CE0), RectangleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = " COST RS. 50 ", fontSize = 21.sp)
        }

        Spacer(modifier = Modifier.height(22.dp))

        Image(painter = painterResource(id = R.drawable.qrcode), contentDescription = "")

        Spacer(modifier = Modifier.height(22.dp))


        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xC9677CE0)),
                onClick = {

                }) {
                Text(text = "PRINT", fontSize = 20.sp)
            }

            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xC9677CE0)),
                onClick = {

                }) {
                Text(text = "ADD ", fontSize = 20.sp)
            }

            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xC9677CE0)),
                onClick = {

                }) {
                Text(text = "BACK", fontSize = 20.sp)
            }
        }


    }
}

@Composable
fun TextComponents(left: String, right: String) {
    Row(
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "$left : ", fontSize = 19.sp, color = Color.Gray)
        Text(text = "$right ", fontSize = 19.sp, color = Color.Black)
    }

}


@Preview(showBackground = true)
@Composable
fun ReceiptScreenPreview() {
    ReceiptScreen(navController = rememberNavController())
}