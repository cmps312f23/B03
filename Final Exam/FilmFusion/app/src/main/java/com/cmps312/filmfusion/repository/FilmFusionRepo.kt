package com.cmps312.filmfusion.repository

import android.content.Context
import android.util.Log
import com.cmps312.filmfusion.entity.Genre
import com.cmps312.filmfusion.entity.Movie
import kotlinx.serialization.json.Json


class FilmFusionRepo(private val context: Context) {
    private var movies = mutableListOf<Movie>()
    private var genres = mutableListOf<Genre>()

    fun getMovies(): List<Movie> {
//        read from the assets folder
        if (movies.isEmpty()) {
            val jsonText = context
                .assets
                .open("movies.json")
                .bufferedReader().use { it.readText() }

            movies = Json { ignoreUnknownKeys = true }
                .decodeFromString(jsonText)
        }
        return movies
    }

    fun getGenres(): List<Genre> {
//        read from the assets folder
        if (genres.isEmpty()) {
            val jsonText = context
                .assets
                .open("genres.json")
                .bufferedReader().use { it.readText() }

            genres = Json { ignoreUnknownKeys = true }
                .decodeFromString(jsonText)
        }

        return genres

    }

    fun deleteMovie(movie: Movie) {
        movies = movies.filter { it.id != movie.id }.toMutableList()
    }


    fun updateMovie(movie: Movie) {
//        update a movie
        val index = getMovies().indexOfFirst { it.id == movie.id }
        Log.d("TAG", "Called")

        if (index != -1)
            movies[index] = movie
    }

    fun filterMoviesByGenre(genreId: Int): List<Movie> = getMovies()
        .filter { it.genreId == genreId }


    fun searchMovies(search: String): List<Movie> =
        if (search.isEmpty()) getMovies()
        else getMovies().filter { movie ->
            movie.title.contains(search, true) or
                    movie.director.contains(search, true)
        }

    fun getGenre(genreId: Int): Genre = getGenres().first { it.id == genreId }

}

fun main(args: Array<String>) {
    val listOfName = listOf("A", "B", "C")
    val index = listOfName.indexOfFirst { it == "B" }
    println(index)
}