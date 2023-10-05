package com.example.stadiums.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.stadiums.model.Stadium
import com.example.stadiums.ui.theme.StadiumsTheme

@Composable
fun StadiumCard(stadium : Stadium){
    Text(text = stadium.name)
}

@Preview
@Composable
fun StadiumCardPreview(){
    val stadium = Stadium("Lusail City Stadium",
        "Doha", "Opened" ,
        seatingCapacity = 10000 ,
        imageName = "lusail_city")

    StadiumsTheme {
        StadiumCard(stadium)
    }
}