package com.example.navigationsample

import android.content.Context
import androidx.room.Room

object  Graph {
    lateinit var database: WishDatabase
    val wishRepository by lazy{ // this variable is initialized only while it is needed, thread safe, zmienna zostanie utworzona tylko raz
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){ // initialization, tworzy instancje bazy
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}