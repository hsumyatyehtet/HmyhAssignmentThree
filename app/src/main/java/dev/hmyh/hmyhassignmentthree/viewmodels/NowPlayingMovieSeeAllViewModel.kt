package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.utils.BASE_URL

class NowPlayingMovieSeeAllViewModel: ViewModel(),MovieListDelegate{

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private var nowPlayingMovie: MutableLiveData<NowPlayingMovieVO> = MutableLiveData()

    private val mMovie = ArrayList<MovieListVO>()
    private val mMovieListLiveData = MutableLiveData<List<MovieListVO>>()

    private var progressLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    private val navigateToMovieDetail: MutableLiveData<Long> = MutableLiveData()

    fun loadNowPlayingMovie(){
        mModel.loadNowPlayingMovie(
            onSuccess = {movie->
                nowPlayingMovie.postValue(movie)
                movie.movieList?.let {
                    mMovie.addAll(it)
                    mMovieListLiveData.value = mMovie
                }
            },
            onFailure = {}
        )
    }

    fun loadMoreNowPlayingMovie(){
        var page = 0L
        var totalPage = 0L

        nowPlayingMovie.value?.page?.let {
            page = it
        }
        nowPlayingMovie.value?.totalPage?.let {
            totalPage = it
        }

        if (page <= totalPage) {
            page++
            progressLiveData.postValue(1)
            mModel.loadMoreNowPlayingMovie(
                BASE_URL,  page,
                onSuccess = {movie->
                    nowPlayingMovie.postValue(movie)
                    movie.movieList?.let {
                        mMovie.addAll(it)
                        mMovieListLiveData.value = mMovie
                    }
                    progressLiveData.postValue(0)
                },
                onFailure = {
                    progressLiveData.postValue(0)
                })
        }

    }

    fun getShowOrHideProgress(): MutableLiveData<Int>{
        return progressLiveData
    }

    fun getNowPlayingMovieList(): MutableLiveData<List<MovieListVO>>{
        return mMovieListLiveData
    }

    override fun onTapMovieItem(movieId: Long) {
        navigateToMovieDetail.postValue(movieId)
    }

    fun getNavigateToMovieDetailLiveData(): LiveData<Long> {
        return navigateToMovieDetail
    }

}