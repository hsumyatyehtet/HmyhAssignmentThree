package dev.hmyh.hmyhassignmentthree.view.hoder

import android.view.View
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieListVO

class UpcomingMovieListViewHolder(itemView: View):
    BaseViewHolder<NowPlayingMovieListVO>(itemView) {

    init {

    }

    override fun bindData(data: NowPlayingMovieListVO) {
        mData = data

//        var photoPath ="http://image.tmdb.org/t/p/w500"
//
//        Glide.with(itemView.context)
//            .load(photoPath+data.posterPath)
//            .into(itemView.ivMovieImage)
//        itemView.tvMovieTitle.text = data.title
    }

}