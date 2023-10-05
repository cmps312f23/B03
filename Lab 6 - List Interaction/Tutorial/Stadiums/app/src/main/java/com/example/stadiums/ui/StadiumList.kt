package com.example.stadiums.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stadiums.R
import com.example.stadiums.model.Stadium
import com.example.stadiums.ui.theme.StadiumsTheme

@Composable
fun StadiumCard(stadium: Stadium) {
    Card(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.al_rayan),
                contentDescription = "image of stadium",
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
            )
            Column {
                Text(text = stadium.name,
                    style = MaterialTheme.typography.titleLarge
                    )
                Text(text = "City : ${stadium.city}")
                Text(text = "Status : ${stadium.status}")
                Text(text = "Capacity : ${stadium.seatingCapacity}")
            }
        }
    }
}

@Preview
@Composable
fun StadiumCardPreview() {
    val stadium = Stadium(
        "Lusail City Stadium",
        "Doha", "Opened",
        seatingCapacity = 10000,
        imageName = "lusail_city"
    )

    StadiumsTheme {
        StadiumCard(stadium)
    }
}