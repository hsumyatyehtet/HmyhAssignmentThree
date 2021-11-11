package dev.hmyh.hmyhassignmentthree.view.hoder

import android.view.View
import com.bumptech.glide.Glide
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.utils.PHOTO_PATH
import kotlinx.android.synthetic.main.view_holder_in_movie_list.view.*

class PopularMovieListViewHolder(itemView: View):
    BaseViewHolder<MovieListVO>(itemView) {

    init {

    }

    override fun bindData(data: MovieListVO) {
        mData = data

        Glide.with(itemView.context)
            .load(PHOTO_PATH+data.posterPath)
            .into(itemView.ivMovieImage)
        itemView.tvMovieTitle.text = data.title
    }

}