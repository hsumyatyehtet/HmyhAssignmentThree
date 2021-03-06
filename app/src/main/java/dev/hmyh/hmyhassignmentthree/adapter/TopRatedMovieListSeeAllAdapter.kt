package dev.hmyh.hmyhassignmentthree.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.view.hoder.NowPlayingMovieListSeeAllViewHolder
import dev.hmyh.hmyhassignmentthree.view.hoder.NowPlayingMovieListViewHolder
import dev.hmyh.hmyhassignmentthree.view.hoder.PopularMovieListSeeAllViewHolder
import dev.hmyh.hmyhassignmentthree.view.hoder.TopRatedMovieListSeeAllViewHolder

class TopRatedMovieListSeeAllAdapter(val delegate: MovieListDelegate):
    BaseRecyclerAdapter<TopRatedMovieListSeeAllViewHolder, MovieListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieListSeeAllViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_in_movie_search,parent,false)
        return TopRatedMovieListSeeAllViewHolder(view,delegate)
    }

}