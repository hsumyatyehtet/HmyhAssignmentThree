package dev.hmyh.hmyhassignmentthree.view.hoder

import android.view.View
import com.bumptech.glide.Glide
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieListVO
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.view_holder_in_movie_list.view.*

class NowPlayingMovieListViewHolder(itemView: View):
    BaseViewHolder<NowPlayingMovieListVO>(itemView) {

    init {

    }

    override fun bindData(data: NowPlayingMovieListVO) {
        mData = data

        var photoPath ="http://image.tmdb.org/t/p/w500"

        Glide.with(itemView.context)
            .load(photoPath+data.posterPath)
            .into(itemView.ivMovieImage)
        itemView.tvMovieTitle.text = data.title
    }

}