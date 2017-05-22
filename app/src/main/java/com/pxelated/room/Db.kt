package com.pxelated.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by nano on 5/21/17.
 */

@Database(entities = arrayOf(Person::class), version = 1)
abstract class Db: RoomDatabase() {
    abstract fun personDao(): PersonDao
}
