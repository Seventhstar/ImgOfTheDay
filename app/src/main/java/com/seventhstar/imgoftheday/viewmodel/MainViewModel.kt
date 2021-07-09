package com.seventhstar.imgoftheday.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.seventhstar.imgoftheday.model.Repository
import com.seventhstar.imgoftheday.model.RepositoryImpl

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getLocalWishes() = getWishesFromLocalStorage()

    private fun getWishesFromLocalStorage() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWishesFromLocalStorage()))
        }.start()
    }

}
