package com.practice.mvvmpoc.ui.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import com.practice.mvvmpoc.R
import com.practice.mvvmpoc.ui.components.CarouselViewComponent
import com.practice.mvvmpoc.viewmodel.MainViewModel

class MainFragment : Fragment(), View.OnClickListener {


    private lateinit var mView: View
    private lateinit var mCarouselImage1: CarouselViewComponent
    private lateinit var mCarouselImage2: CarouselViewComponent
    private lateinit var mCarouselImage3: CarouselViewComponent
    private lateinit var mCarouselImage4: CarouselViewComponent
    private lateinit var mBottomButton: Button
    private lateinit var mBottomContainer: ViewGroup
    private lateinit var mCarouselView: ViewGroup

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.main_fragment, container, false)
        initViewModels()
        return mView
    }

    private fun initViewModels() {

        viewModel = activity.let { ViewModelProviders.of(it!!).get(MainViewModel::class.java) }

        //viewmodel to update bottom view
        viewModel.getBottomContainerColor()?.observe(this, Observer<Int> {

                mBottomContainer.setBackgroundColor(it)
        })

        //viewmodel to update top carousel view
        viewModel.getCarouselBackgroundColor()?.observe(this, Observer<Int> {
                mCarouselView.setBackgroundColor(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun updateBottomColor(mColor: Int) {

        viewModel.mColorSelectedForBottom.value =mColor
//        viewModel.setBottomColor(mColor)
        Toast.makeText(activity,mColor.toString(),Toast.LENGTH_SHORT).show()
    }
    private fun updateCarouselColor(mColor: Int) {
        viewModel.mColorSelectedForTop.value =mColor
        Toast.makeText(activity,mColor.toString(),Toast.LENGTH_SHORT).show()
    }

    private fun initViews() {
        mCarouselImage1 = mView.findViewById(R.id.cv_1)
        mCarouselImage2 = mView.findViewById(R.id.cv_2)
        mCarouselImage3 = mView.findViewById(R.id.cv_3)
        mCarouselImage4 = mView.findViewById(R.id.cv_4)
        mBottomButton = mView.findViewById(R.id.btn_bottomView)
        mBottomContainer = mView.findViewById(R.id.bottomView)
        mCarouselView = mView.findViewById(R.id.topView)


        mCarouselImage1.setOnClickListener(this)
        mCarouselImage2.setOnClickListener(this)
        mCarouselImage3.setOnClickListener(this)
        mCarouselImage4.setOnClickListener(this)
        mCarouselView.setOnClickListener(this)

        mBottomButton.setOnClickListener(this)
        mBottomContainer.setOnClickListener(this)


    }

    override fun onClick(mView: View?) {

        val mBackground = mView?.background
        var clickedColor = Color.TRANSPARENT
        if (mBackground is ColorDrawable) {
            clickedColor = mBackground.color
        }
        if (mView?.id!=R.id.bottomView && mView?.id!=R.id.btn_bottomView) {
            updateBottomColor(clickedColor)
        }else{
            updateCarouselColor(clickedColor)
        }

    }


}
