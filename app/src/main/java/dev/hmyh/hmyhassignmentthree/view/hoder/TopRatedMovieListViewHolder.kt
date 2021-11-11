package dev.hmyh.hmyhassignmentthree.view.hoder

import android.view.View
import com.bumptech.glide.Glide
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO

class TopRatedMovieListViewHolder(itemView: View):
    BaseViewHolder<MovieListVO>(itemView) {

    init {

    }

    override fun bindData(data: MovieListVO) {
        mData = data

//        var photoPath ="http://image.tmdb.org/t/p/w500"
//
//        Glide.with(itemView.context)
//            .load(photoPath+data.posterPath)
//            .into(itemView.ivMovieImage)
//        itemView.tvMovieTitle.text = data.title
    }

}