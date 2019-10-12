package com.practice.mvvmpoc.viewmodel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

     var mColorSelectedForBottom: MutableLiveData<Int> = MutableLiveData()
     var mColorSelectedForTop: MutableLiveData<Int> = MutableLiveData()


    init {
        mColorSelectedForBottom.value=Color.DKGRAY
        mColorSelectedForTop.value=Color.DKGRAY
    }

    fun getBottomContainerColor():LiveData<Int>?{
        return mColorSelectedForBottom
    }
    fun getCarouselBackgroundColor():LiveData<Int>?{
        return mColorSelectedForTop
    }


}
