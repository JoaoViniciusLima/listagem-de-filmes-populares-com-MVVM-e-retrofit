package com.example.movie_list.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie_list.domain.MovieResponse
import com.example.movie_list.repositores.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel(){

    val popularMovies = MutableLiveData<MovieResponse>()

    val networkState = MutableLiveData<String>()

    fun getPopularMovie(page: Int){
        networkState.postValue("loading")
        val request = repository.getPopularMovie(page)
        request.enqueue(object : Callback<MovieResponse>{

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                networkState.postValue("")
                popularMovies.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                networkState.postValue("error")
            }

        }
        )
    }
}