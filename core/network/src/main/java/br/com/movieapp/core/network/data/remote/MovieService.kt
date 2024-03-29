package br.com.movieapp.core.data.remote

import br.com.movieapp.core.network.data.remote.response.MoviesDetailReponse
import br.com.movieapp.core.network.data.remote.response.MoviesResponse
import br.com.movieapp.core.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MoviesResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int
    ): SearchResponse

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int
    ): MoviesDetailReponse

    @GET("movie/{movie_id}/similar")
    suspend fun getMoviesSimilar(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int
    ): MoviesResponse
}