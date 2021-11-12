package dev.hmyh.hmyhassignmentthree.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoVO
import io.reactivex.Completable

@Dao
interface MovieVideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieVideo(movieVideo: MovieVideoVO): Completable

    @Query("SELECT * from movie_video where id =:movieId")
    fun getMovieVideo(movieId: Long): LiveData<MovieVideoVO>

}