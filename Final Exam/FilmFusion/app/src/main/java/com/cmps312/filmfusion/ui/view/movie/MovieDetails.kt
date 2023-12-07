package com.cmps312.filmfusion.ui.view.movie


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.filmfusion.entity.Movie
import com.cmps312.filmfusion.repository.FilmFusionRepo

@Composable
fun MovieDetails(movie: Movie, onBackPressed: () -> Unit) {

//    get image using a name from resource folder
    val imageId = LocalContext.current.resources.getIdentifier(
        movie.poster,
        "drawable",
        LocalContext.current.packageName
    )

    OutlinedCard(
        modifier = Modifier
            .padding(10.dp, 20.dp, 10.dp, 10.dp)


    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),

            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp, 10.dp)
                .align(CenterHorizontally),
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null, // decorative
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                        onBackPressed()
                    }
            ) {
                Text(
                    text = "Title ${movie.title}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = "Director : ${movie.director}", fontStyle = FontStyle.Italic)
                Text(text = "Movie Rating : ${movie.rating}/10", fontWeight = FontWeight.ExtraBold)
                Text(text = "Release Date : ${movie.releaseDate}", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsPreview() {
    val context = LocalContext.current
    val movie = FilmFusionRepo(context).getMovies()[0]
    MovieDetails(
        movie,
        onBackPressed = {}
    )
}
