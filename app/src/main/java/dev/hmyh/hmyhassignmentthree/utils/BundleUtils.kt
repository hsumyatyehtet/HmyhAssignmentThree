package dev.hmyh.hmyhassignmentthree.utils

import android.os.Bundle

fun getBundleMovieDetail(movieId: Long): Bundle{

    return Bundle().apply {
        putLong("movie_id",movieId)
    }

}

fun getBundleMovieList(movieId: Long): Bundle{
    return Bundle().apply {
        putLong("movie_id",movieId)
    }
}

fun getBundleMovieVideoKey(movieKey: String): Bundle{
    return Bundle().apply {
        putString("movie_key",movieKey)
    }
}