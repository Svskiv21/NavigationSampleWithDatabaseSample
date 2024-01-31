package com.example.navigationsample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel (
    private val wishRepository: WishRepository
): ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")
    fun onWishTitleChanged(newString:String){
        wishTitleState = newString
    }
    fun onWishDescriptionChanged(newString:String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>> // lateinit obiecuje kompilatorowi ze przypisze wartosc zmiennej
    // zanim zostanie wykonana na niej jakakolwiek operacja, nie mozna uzywac z prymitywnymi typami

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }

        fun addWish(wish: Wish){
            viewModelScope.launch(Dispatchers.IO) {// optimize IO operations
                wishRepository.addAWish(wish= wish)
            }
        }

        fun getAWishById(id: Long): Flow<Wish>{
            return wishRepository.getAWishById(id= id)
        }

        fun updateWish(wish: Wish){
            viewModelScope.launch(Dispatchers.IO) {// optimize IO operations
                wishRepository.updateAWish(wish= wish)
            }
        }

        fun deleteWish(wish: Wish){
            viewModelScope.launch(Dispatchers.IO) {// optimize IO operations
                wishRepository.deleteAWish(wish= wish)
            }
        }
    }
}