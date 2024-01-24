package com.example.movie_list.repositores

import com.example.movie_list.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService ) {

    fun getPopularMovie(page: Int ) = retrofitService.getPopularMovie(page)

    fun getMovieDetails(id: Int ) = retrofitService.getMovieDetails(id)
}