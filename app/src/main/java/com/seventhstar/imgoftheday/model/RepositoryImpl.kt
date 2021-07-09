package com.seventhstar.imgoftheday.model

class RepositoryImpl : Repository {

    override fun getWishesFromLocalStorage(): List<Wish> {
        return getLocalWishes()
    }
}
