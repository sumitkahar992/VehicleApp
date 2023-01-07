package com.example.vehicleapp.presentation.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vehicleapp.R
import com.example.vehicleapp.presentation.navigation.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 63.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.car),
            contentDescription = "",
            modifier = Modifier.size(80.dp)
        )

        Divider(modifier = Modifier.padding(start = 150.dp, end = 150.dp), color = Color.LightGray)

        Text(
            text = "AWTO.Ai",
            fontSize = 23.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(33.dp))

        Card(
            backgroundColor = Color.White,
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .height(380.dp)
                .width(330.dp),
            elevation = 18.dp

        ) {
            Column(
                modifier = Modifier.padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly

            ) {
                Text(
                    text = "Login Account",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "E-Mail") }
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") }
                )

                Button(
                    modifier = Modifier
                        .width(222.dp)
                        .height(50.dp),
                    onClick = {
                        navController.navigate(Screen.AddVehicleScreen.route)
                    },
                    shape = RoundedCornerShape(33.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                ) {
                    Text(text = "LOGIN", fontSize = 16.sp, color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        Row {
            Text(
                text = "No Account ",
                fontSize = 17.sp,
                color = Color.Gray
            )
            Text(
                text = " ? Create new one",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Blue,
                modifier = Modifier.clickable { }
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
fun Prev() {
    LoginScreen(navController = rememberNavController())
}