package br.com.movieapp.movie_popular_feature.domain.repository


import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import br.com.movieapp.commons.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviePopularRepository {

    fun getPopularMovies(): PagingSource<Int, Movie>
}