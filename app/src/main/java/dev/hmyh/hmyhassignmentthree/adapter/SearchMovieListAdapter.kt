package dev.hmyh.hmyhassignmentthree.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.view.hoder.NowPlayingMovieListViewHolder
import dev.hmyh.hmyhassignmentthree.view.hoder.SearchMovieListViewHolder

class SearchMovieListAdapter(val delegate: MovieListDelegate): BaseRecyclerAdapter<SearchMovieListViewHolder, MovieListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_in_movie_search,parent,false)
        return SearchMovieListViewHolder(view,delegate)
    }

}