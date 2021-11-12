package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.*
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.persistance.daos.UpcomingMovieDao

class MainFragmentViewModel : ViewModel(),MovieListDelegate {

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private val mNowPlayingMovie: LiveData<NowPlayingMovieVO> = mModel.getNowPlayingMovie()
    private val mPopularMovie: LiveData<PopularMovieVO> = mModel.getPopularMovie()
    private val mTopRatedMovie: LiveData<TopRatedMovieVO> = mModel.getTopRatedMovie()
    private val mUpcomingMovie: LiveData<UpComingMovieVO> = mModel.getUpComingMovie()

    private val navigateToMovieDetail: MutableLiveData<Long> = MutableLiveData()

    fun onUiReady() {

        mModel.loadNowPlayingMovie(onSuccess = {},onFailure = {})

        mModel.loadPopularMovie(onSuccess = {},onFailure = {})

        mModel.loadTopRatedMovie(onSuccess = {},onFailure = {})

        mModel.loadUpComingMovie(onSuccess = {}, onFailure = {})

    }

    fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO>{
        return mNowPlayingMovie
    }

    fun getPopularMovie():LiveData<PopularMovieVO>{
        return mPopularMovie
    }

    fun getTopRatedMovie():LiveData<TopRatedMovieVO>{
        return mTopRatedMovie
    }

    fun getUpComingMovie(): LiveData<UpComingMovieVO>{
        return mUpcomingMovie
    }

    fun getNavigateToMovieDetailLiveData(): LiveData<Long>{
        return navigateToMovieDetail
    }

    override fun onTapMovieItem(movieId: Long) {
        navigateToMovieDetail.postValue(movieId)
    }

}