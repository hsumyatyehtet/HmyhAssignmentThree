package dev.hmyh.hmyhassignmentthree.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.view.hoder.NowPlayingMovieListSeeAllViewHolder
import dev.hmyh.hmyhassignmentthree.view.hoder.NowPlayingMovieListViewHolder

class NowPlayingMovieListSeeAllAdapter(val delegate: MovieListDelegate):
    BaseRecyclerAdapter<NowPlayingMovieListSeeAllViewHolder, MovieListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMovieListSeeAllViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_in_movie_search,parent,false)
        return NowPlayingMovieListSeeAllViewHolder(view,delegate)
    }

}