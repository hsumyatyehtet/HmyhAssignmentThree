package dev.hmyh.hmyhassignmentthree.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import io.reactivex.Completable

@Dao
interface NowPlayingMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlayingMovie(nowPlayingMovieVO: NowPlayingMovieVO): Completable

    @Query("SELECT * from now_playing_movie")
    fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO>
}