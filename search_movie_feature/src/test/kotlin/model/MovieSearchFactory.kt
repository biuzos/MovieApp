package br.com.movieapp.core.domain.model

import br.com.movieapp.commons.model.Movie
import br.com.movieapp.search_movie_feature.data.model.MovieSearch

class MovieSearchFactory {

    fun create(poster: Poster) = when (poster) {

        Poster.Avengers -> MovieSearch(
            id = 1,
            voteAverage = 7.5,
            imageUrl = "imageUrl"
        )

        Poster.JohnWick -> MovieSearch(
            id = 2,
            voteAverage = 8.0,
            imageUrl = "imageUrl"
        )
    }

    sealed class Poster {
        object Avengers : Poster()
        object JohnWick : Poster()
    }
}