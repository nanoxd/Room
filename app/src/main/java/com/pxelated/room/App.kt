package com.pxelated.room

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by nano on 5/21/17.
 */

class App : Application() {
    companion object {
        var database: Db? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, Db::class.java, "contacts").build()
    }
}
