package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.MetaVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.SearchMovieVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.utils.BASE_URL

class SearchFragmentViewModel : ViewModel(), MovieListDelegate {

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private var searchMovie: MutableLiveData<SearchMovieVO> = MutableLiveData()
    private val navigateToMovieDetail: MutableLiveData<Long> = MutableLiveData()

    private val mMovie = ArrayList<MovieListVO>()
    private val mMovieListLiveData = MutableLiveData<List<MovieListVO>>()

    private var mMetaVO: MetaVO? = null

    fun loadSearchMovie(searchWord: String) {
//        mModel.loadSearchMovie(searchWord,
//            onSuccess = {
//                        searchMovie.postValue(it)
//            },
//            onFailure = {
//
//            })


        mModel.loadSearchMovie(searchWord,
            onSuccess = { movie ->

                searchMovie.postValue(movie)

                movie.movieList?.let {

                    mMovie.addAll(it)
                    mMovieListLiveData.value = mMovie

                }
            },
            onFailure = {}
        )
    }

    fun loadMoreSearchMovie(searchWord: String) {

        var page = 0L
        var totalPage = 0L

        searchMovie.value?.page?.let {
            page = it
        }

        searchMovie.value?.totalPages?.let {
            totalPage = it
        }

        if (page <= totalPage) {

            page++
            mModel.loadMoreSearchMovie(BASE_URL, searchWord, page,
                onSuccess = {movie->
                    searchMovie.postValue(movie)

                    movie.movieList?.let {

                        mMovie.addAll(it)
                        mMovieListLiveData.value = mMovie

                    }
                }, onFailure = {

                })

        }

    }

    fun getSearchMovieList(): MutableLiveData<List<MovieListVO>> {
        return mMovieListLiveData
    }

//    fun getSearchMovie(): LiveData<SearchMovieVO>{
//        return searchMovie
//    }

    //delegate override function
    override fun onTapMovieItem(movieId: Long) {
        navigateToMovieDetail.postValue(movieId)
    }

    fun getNavigateToMovieDetailLiveData(): LiveData<Long> {
        return navigateToMovieDetail
    }

}