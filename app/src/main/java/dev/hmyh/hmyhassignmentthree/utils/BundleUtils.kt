package dev.hmyh.hmyhassignmentthree.utils

import android.os.Bundle

fun getBundleMovieDetail(movieId: Long): Bundle{

    return Bundle().apply {
        putLong("movie_id",movieId)
    }

}