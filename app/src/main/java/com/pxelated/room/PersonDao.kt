package com.pxelated.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Created by nano on 5/21/17.
 */

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getPeople(): Flowable<List<Person>>

    @Insert
    fun add(person: Person)
}