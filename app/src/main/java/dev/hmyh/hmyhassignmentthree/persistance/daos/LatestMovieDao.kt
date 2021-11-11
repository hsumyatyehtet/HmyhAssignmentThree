package dev.hmyh.hmyhassignmentthree.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import io.reactivex.Completable

@Dao
interface LatestMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLatestMovie(latestMovie: LatestMovieVO): Completable

    @Query("SELECT * from latest_movie")
    fun getLatestMovie(): LiveData<LatestMovieVO>

}