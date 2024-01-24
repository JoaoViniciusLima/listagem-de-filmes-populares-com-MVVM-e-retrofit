package com.example.movie_list.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie_list.repositores.MainRepository

class MovieDetailsViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MovieDetailsViewModel(this.repository) as T
    }
}
