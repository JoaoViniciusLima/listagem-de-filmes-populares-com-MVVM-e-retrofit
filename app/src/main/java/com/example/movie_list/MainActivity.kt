package com.example.movie_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_list.api.RetrofitService
import com.example.movie_list.domain.Movie
import com.example.movie_list.repositores.MainRepository
import com.example.movie_list.viewModel.MainViewModel
import com.example.movie_list.viewModel.MainViewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_list.adapters.MovieAdapter
import com.example.movie_list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        val retrofitService = RetrofitService.getInstance()

        val viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java
        )
        val recyclerView = binding.recycleView


        var page = 1

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val adapter = MovieAdapter(this)
        recyclerView.adapter = adapter

        val movieList : MutableList<Movie> = mutableListOf()

        viewModel.popularMovies.observe(this, Observer { movieResponse ->
            movieList.addAll(movieResponse.movieList)
            page = movieResponse.page + 1

            adapter.updateData(movieList)
        })

        viewModel.networkState.observe(this, Observer {networkState ->
            if (networkState == "loading") {
                binding.ProgressBar.visibility = View.VISIBLE
            } else {
                binding.ProgressBar.visibility = View.GONE
                if(networkState == "error"){

                    binding.ErrorMessage.visibility = View.VISIBLE
                } else{
                    binding.ErrorMessage.visibility = View.GONE
                }
            }
        })

        viewModel.getPopularMovie(page)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItemPosition == totalItemCount - 1 && dy > 0) {
                    viewModel.getPopularMovie(page)
                }
            }
        })
        setContentView(binding.root)


    }

}