package com.seventhstar.imgoftheday.model

interface Repository {

    fun getWishesFromLocalStorage(): List<Wish>

}
