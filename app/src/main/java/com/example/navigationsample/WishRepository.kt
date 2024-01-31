package com.example.navigationsample

import com.example.navigationsample.ui.theme.WishDao
import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addAWish(wish: Wish){ // suspend jest do asynchronicznego wykonywania się funkcji
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes() // Flow ma juz w sobie coroutines, wiec nie trzeba dawac suspend

    fun getAWishById(id: Long): Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }
}