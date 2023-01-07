package com.example.vehicleapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AppBar(title: String, navController: NavController, content: @Composable RowScope.() -> Unit) {

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 0.7.dp
    ) {
        Icon(
            modifier = Modifier
                .padding(5.dp)
                .size(37.dp)
                .clickable {
                    navController.popBackStack()
                },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = ""
        )

        Spacer(modifier = Modifier.width(33.dp))

        Text(
            text = title,
            textAlign = TextAlign.Start,
            modifier = Modifier,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )

        content()
    }
}


@Preview(showBackground = true)
@Composable
fun Prev() {
    AppBar(title = "Add Vehicle", navController = rememberNavController()){}
}