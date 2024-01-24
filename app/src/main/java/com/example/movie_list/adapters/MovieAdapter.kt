package com.example.movie_list.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_list.domain.Movie
import com.bumptech.glide.Glide
import com.example.movie_list.MovieDetailsActivity
import com.example.movie_list.R

class MovieAdapter(private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList: List<Movie> = emptyList()


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: CardView =  itemView.findViewById(R.id.card_view)
        val title: TextView = itemView.findViewById(R.id.movieTitle)
        val releaseDate: TextView = itemView.findViewById(R.id.movieReleaseDate)
        val poster: ImageView = itemView.findViewById(R.id.moviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val imageUrlBase = "https://image.tmdb.org/t/p/w342"
        val currentMovie = movieList[position]
        holder.title.text = currentMovie.title
        holder.releaseDate.text = currentMovie.releaseDate
        Glide.with(context)
            .load(imageUrlBase + currentMovie.posterPath)
            .fitCenter()
            .into(holder.poster)

        holder.card.setOnClickListener{
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra("id", currentMovie?.id)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateData(newMovies: List<Movie>) {
        movieList = newMovies
        notifyDataSetChanged()
    }
}
