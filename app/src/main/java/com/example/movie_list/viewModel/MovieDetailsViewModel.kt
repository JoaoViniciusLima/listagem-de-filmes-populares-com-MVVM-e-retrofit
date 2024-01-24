package com.example.movie_list.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie_list.domain.MovieDetails
import com.example.movie_list.repositores.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val movieDetails = MutableLiveData<MovieDetails>()

    val networkState = MutableLiveData<String>()

    fun getMovieDetails(id: Int){
        networkState.postValue("loading")
        val request = repository.getMovieDetails(id)
        request.enqueue(object : Callback<MovieDetails> {

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                networkState.postValue("")
                movieDetails.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                networkState.postValue("error")
            }

        }
        )
    }

}