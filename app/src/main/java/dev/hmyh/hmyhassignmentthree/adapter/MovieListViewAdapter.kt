package dev.hmyh.hmyhassignmentthree.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoListVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.delegate.MovieListViewDelegate
import dev.hmyh.hmyhassignmentthree.view.hoder.MovieListViewViewHolder
import dev.hmyh.hmyhassignmentthree.view.hoder.NowPlayingMovieListViewHolder

class MovieListViewAdapter(val delegate: MovieListViewDelegate): BaseRecyclerAdapter<MovieListViewViewHolder, MovieVideoListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_in_movie_view,parent,false)
        return MovieListViewViewHolder(view,delegate)
    }

}