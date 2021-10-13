package com.example.shaadi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shaadi.model.Results
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface HomeDao {

    @Query("SELECT * FROM Results")
      fun getAllResultFromDb(): Observable<List<Results>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insertAll(achieved: List<Results>?)

    @Query("DELETE FROM Results")
    fun deleteAll(): Int

    @Query("UPDATE Results SET statusFlag=:statusFlag WHERE primerId = :id AND email=:email")
    fun update(statusFlag: Int?, id: Int, email:String):Int


}
