package dev.hmyh.hmyhassignmentthree.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.PopularMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.TopRatedMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.UpComingMovieVO
import io.reactivex.Completable

@Dao
interface UpcomingMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpComingMovie(upComingMovieVO: UpComingMovieVO): Completable

    @Query("SELECT * from up_coming_movie")
    fun getUpComingMovie(): LiveData<UpComingMovieVO>
}