package dev.hmyh.hmyhassignmentthree.view.hoder

import android.view.View
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoListVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListViewDelegate
import kotlinx.android.synthetic.main.view_holder_in_movie_view.view.*

class MovieListViewViewHolder(itemView: View,delegate: MovieListViewDelegate):
    BaseViewHolder<MovieVideoListVO>(itemView){

    init {
        itemView.setOnClickListener {
            mData?.let { movieVideo->
               movieVideo.key?.let { key->
                   delegate.onTapMovieView(key)
               }
            }
        }
    }

    override fun bindData(data: MovieVideoListVO) {
        mData = data

        itemView.tvMovieViewTitle.text = data.name ?: ""
        itemView.tvMovieViewType.text = data.type ?: ""

    }

}