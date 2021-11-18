package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.PopularMovieVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.utils.BASE_URL

class PopularMovieSeeAllViewModel: ViewModel(),MovieListDelegate{

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private var popularMovie: MutableLiveData<PopularMovieVO> = MutableLiveData()

    private val mMovieList = ArrayList<MovieListVO>()
    private val mMovieListLiveData = MutableLiveData<List<MovieListVO>>()

    private var progressLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    private var navigateToMovieDetail: MutableLiveData<Long> = MutableLiveData()

    fun loadPopularMovie(){
        mModel.loadPopularMovie(
            onSuccess = {movie ->
                popularMovie.postValue(movie)
                movie.movieList?.let { movieList->
                    mMovieList.addAll(movieList)
                    mMovieListLiveData.value = mMovieList
                }
            },
            onFailure = {

            }
        )
    }

    fun loadMorePopularMovie(){
        var page = 0L
        var totalPage = 0L

        popularMovie.value?.page?.let {
            page = it
        }
        popularMovie.value?.totalPage?.let {
            totalPage = it
        }

        if (page <= totalPage) {
            page++
            progressLiveData.postValue(1)
            mModel.loadMorePopularMovie(
                BASE_URL,  page,
                onSuccess = {movie->
                    popularMovie.postValue(movie)
                    movie.movieList?.let {
                        mMovieList.addAll(it)
                        mMovieListLiveData.value = mMovieList
                    }
                    progressLiveData.postValue(0)
                },
                onFailure = {
                    progressLiveData.postValue(0)
                })
        }

    }

    fun getPopularMovieList(): MutableLiveData<List<MovieListVO>>{
        return mMovieListLiveData
    }

    fun getShowOrHideProgress(): MutableLiveData<Int>{
        return progressLiveData
    }

    override fun onTapMovieItem(movieId: Long) {
        navigateToMovieDetail.postValue(movieId)
    }

    fun getNavigateToMovieDetail(): MutableLiveData<Long>{
        return navigateToMovieDetail
    }

}