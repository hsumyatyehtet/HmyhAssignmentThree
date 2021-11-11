package dev.hmyh.hmyhassignmentthree.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.hmyhassignmentthree.data.vos.*
import io.reactivex.Completable

@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movieDetailVO: MovieDetailVO): Completable

    @Query("SELECT * from movie_detail where id =:movieId")
    fun getMovieDetailById(movieId: Long): LiveData<MovieDetailVO>
}