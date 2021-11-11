package dev.hmyh.hmyhassignmentthree.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieListVO
import dev.hmyh.hmyhassignmentthree.view.hoder.UpcomingMovieListViewHolder

class UpcomingMovieListAdapter(): BaseRecyclerAdapter<UpcomingMovieListViewHolder, NowPlayingMovieListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_in_movie_list,parent,false)
        return UpcomingMovieListViewHolder(view)
    }

//    interface Delegate{
//        fun onTapMovieItem(movieListVO: MovieListVO)
//    }

}