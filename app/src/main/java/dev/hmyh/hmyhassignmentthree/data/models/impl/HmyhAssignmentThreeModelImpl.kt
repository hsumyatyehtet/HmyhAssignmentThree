package dev.hmyh.hmyhassignmentthree.data.models.impl

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.hmyh.hmyhassignmentthree.data.models.BaseAppModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.vos.*
import dev.hmyh.hmyhassignmentthree.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object HmyhAssignmentThreeModelImpl: BaseAppModel(),HmyhAssignmentThreeModel {

    @SuppressLint("CheckResult")
    override fun loadNowPlayingMovie(
        onSuccess: (nowPlayingMovie: NowPlayingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ): LiveData<NowPlayingMovieVO> {
        var liveData=MutableLiveData<NowPlayingMovieVO>()

        mApi.loadNowPlayingMovieList(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { nowPlayingMovie ->
                    mDatabase.nowPlayingMovieDao().insertNowPlayingMovie(nowPlayingMovie).subscribeDBWithCompletable()
                    onSuccess(nowPlayingMovie)
                }
            }, {

            })
        return liveData
    }

    override fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO> {
       return mDatabase.nowPlayingMovieDao().getNowPlayingMovie()
    }

    @SuppressLint("CheckResult")
    override fun loadMoreNowPlayingMovie(
        url: String,
        page: Long,
        onSuccess: (nowPlayingMovie: NowPlayingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {

        mApi.loadMoreNowPlayingMovieList(url+ GET_NOW_PLAYING_MOVIE_LIST, API_KEY_DATA,page).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { nowPlayingMovie ->
                    onSuccess(nowPlayingMovie)
                }
            }

    }

    @SuppressLint("CheckResult")
    override fun loadPopularMovie(
        onSuccess: (popularMovie: PopularMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadPopularMovieList(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { popularMovie ->
                    mDatabase.popularMovieDao().insertPopularMovie(popularMovie).subscribeDBWithCompletable()
                    onSuccess(popularMovie)
                }
            }, {

            })
    }

    override fun getPopularMovie(): LiveData<PopularMovieVO> {
        return mDatabase.popularMovieDao().getPopularMovie()
    }

    @SuppressLint("CheckResult")
    override fun loadMorePopularMovie(
        url: String,
        page: Long,
        onSuccess: (popularMovie: PopularMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadMorePopularMovieList(url+ GET_POPULAR_MOVIE_LIST, API_KEY_DATA,page).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { popularMovie ->
                    onSuccess(popularMovie)
                }
            }
    }

    @SuppressLint("CheckResult")
    override fun loadTopRatedMovie(
        onSuccess: (topRatedMovie: TopRatedMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadTopRatedMovieList(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { topRatedMovie ->
                    mDatabase.topRatedMovieDao().insertTopRatedMovie(topRatedMovie).subscribeDBWithCompletable()
                    onSuccess(topRatedMovie)
                }
            }, {

            })
    }

    override fun getTopRatedMovie(): LiveData<TopRatedMovieVO> {
        return mDatabase.topRatedMovieDao().getTopRatedMovie()
    }

    @SuppressLint("CheckResult")
    override fun loadMoreTopRatedMovie(
        url: String,
        page: Long,
        onSuccess: (topRatedMovie: TopRatedMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadMoreTopRatedMovieList(url+ GET_TOP_RATED_MOVIE, API_KEY_DATA,page).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { topRatedMovie ->
                    onSuccess(topRatedMovie)
                }
            }
    }

    @SuppressLint("CheckResult")
    override fun loadUpComingMovie(
        onSuccess: (upComingMovie: UpComingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadUpComingMovieList(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { upComingMovie ->
                    mDatabase.upcomingMovieDao().insertUpComingMovie(upComingMovie).subscribeDBWithCompletable()
                    onSuccess(upComingMovie)
                }
            }, {

            })
    }

    override fun getUpComingMovie(): LiveData<UpComingMovieVO> {
        return mDatabase.upcomingMovieDao().getUpComingMovie()
    }

    @SuppressLint("CheckResult")
    override fun loadMoreUpComingMovie(
        url: String,
        page: Long,
        onSuccess: (upComingMovie: UpComingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadMoreUpComingMovieList(url+ GET_UP_COMING_MOVIE, API_KEY_DATA,page).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { upComingMovie ->
                    onSuccess(upComingMovie)
                }
            }
    }

    @SuppressLint("CheckResult")
    override fun loadMovieDetail(
        movieId: Long,
        onSuccess: (movieDetailVO: MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadMovieDetail(movieId,API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { movieDetail ->
                    mDatabase.movieDetailDao().insertMovieDetail(movieDetail).subscribeDBWithCompletable()
                    onSuccess(movieDetail)
                }
            }, {

            })
    }

    override fun getMovieDetailById(movieId: Long): LiveData<MovieDetailVO> {
        return mDatabase.movieDetailDao().getMovieDetailById(movieId)
    }

    @SuppressLint("CheckResult")
    override fun loadMovieVideo(
        movieId: Long,
        onSuccess: (movieVideoVO: MovieVideoVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadMovieVideo(movieId,API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { movieVideo ->
                    mDatabase.movieVideoDao().insertMovieVideo(movieVideo).subscribeDBWithCompletable()
                    onSuccess(movieVideo)
                }
            }, {

            })
    }

    override fun getMovieVideo(movieId: Long): LiveData<MovieVideoVO> {
       return mDatabase.movieVideoDao().getMovieVideo(movieId)
    }

    @SuppressLint("CheckResult")
    override fun loadSearchMovie(
        search: String,
        onSuccess: (searchMovieVO: SearchMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadSearchMovie(API_KEY_DATA,search).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { searchMovieVideo ->
                    onSuccess(searchMovieVideo)
                }
            }, {

            })
    }

    @SuppressLint("CheckResult")
    override fun loadMoreSearchMovie(
        url: String,
        search: String,
        page: Long,
        onSuccess: (searchMovieVO: SearchMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadMoreSearchMovie(url+ GET_SEARCH_MOVIE,API_KEY_DATA,search,page).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { searchMovieVideo ->
                    onSuccess(searchMovieVideo)
                }
            }, {
                onFailure(it.toString())
            })

    }

}