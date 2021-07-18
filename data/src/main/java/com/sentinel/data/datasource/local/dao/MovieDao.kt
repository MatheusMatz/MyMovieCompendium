package com.sentinel.data.datasource.local.dao

import androidx.room.*
import com.sentinel.data.datasource.local.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieByID(id: Long): MovieEntity

    @Query("SELECT * FROM movies WHERE isTrendy = :isTrendy")
    suspend fun getTrendiesMovies(isTrendy: Boolean): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendyMovies(movies: List<MovieEntity>)

}
