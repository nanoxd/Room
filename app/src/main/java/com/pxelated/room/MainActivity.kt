package com.pxelated.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe
import io.reactivex.internal.operators.flowable.FlowableReplay.observeOn
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listenForPeople()
        addPerson("Fernando", "Paredes")
    }

    fun addPerson(firstName: String, lastName: String) {
        val person = Person(0, firstName, lastName)

        Single
            .fromCallable { App.database?.personDao()?.add(person) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun listenForPeople() {
        App.database?.personDao()?.getPeople()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { people ->
                println("Got People: $people")
            }

    }
}
