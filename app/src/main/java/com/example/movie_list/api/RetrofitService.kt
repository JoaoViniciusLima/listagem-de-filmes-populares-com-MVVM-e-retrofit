package com.example.movie_list.api

import com.example.movie_list.domain.MovieDetails
import com.example.movie_list.domain.MovieResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


    @GET("movie/popular")
    fun getPopularMovie(
        @Query("page") page: Int
    ): Call<MovieResponse>


    @GET("movie/{movie_id}")
     fun getMovieDetails(
        @Path("movie_id") id: Int
    ): Call<MovieDetails>

    companion object{
        private val retrofitService : RetrofitService by lazy {

            val baseUrl = "https://api.themoviedb.org/3/"

            val interceptor = ApiKeyInterceptor()

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService{
            return retrofitService
        }
    }

}


