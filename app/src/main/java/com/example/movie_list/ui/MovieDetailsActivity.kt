package com.example.movie_list.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movie_list.domain.MovieDetails
import com.example.movie_list.repositores.MainRepository
import com.example.movie_list.viewModel.MovieDetailsViewModel
import com.example.movie_list.viewModel.MovieDetailsViewModelFactory
import java.text.NumberFormat
import java.util.Locale
import com.example.movie_list.databinding.ActivitySingleMovieBinding
import com.example.movie_list.api.RetrofitService

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySingleMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofitService = RetrofitService.getInstance()

        binding = ActivitySingleMovieBinding.inflate(layoutInflater)

        var movieId = intent.getIntExtra("id",0)

        val viewModel = ViewModelProvider(this, MovieDetailsViewModelFactory(MainRepository(retrofitService))).get(
            MovieDetailsViewModel::class.java
        )

        viewModel.movieDetails.observe(this, Observer { movieResponse ->
            setMovieDetailsContend(movieResponse)
        })

        viewModel.networkState.observe(this, Observer {networkState ->
            if (networkState == "loading") {
              binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                if(networkState == "error"){
                        binding.errorMessage.visibility = View.VISIBLE
                }
            }

        })

        viewModel.getMovieDetails(movieId)
        setContentView(binding.root)



    }

    private fun setMovieDetailsContend(it: MovieDetails){
        val posterBaseUrl = "https://image.tmdb.org/t/p/w342"
        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)
        binding.movieTitle.text = it.title
        binding.movieTagline.text = it.tagline
        binding.movieReleaseDate.text = it.releaseDate
        binding.movieRating.text = it.rating
        binding.movieRuntime.text = it.runtime.toString() + " minutes"
        binding.movieBudget.text = formatCurrency.format(it.budget)
        binding.movieRevenue.text = formatCurrency.format(it.revenue)
        binding.movieOverview.text = it.overview

        val moviePosterURL = posterBaseUrl + it.posterPath
        Glide.with(this)
            .load(moviePosterURL)
            .into(binding.ivMoviePoster);
    }


}