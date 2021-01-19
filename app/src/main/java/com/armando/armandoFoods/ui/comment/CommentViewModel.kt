package com.armando.armandoFoods.ui.comment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armando.armandoFoods.Model.CommentModel
import com.armando.armandoFoods.Common.Common
import com.armando.armandoFoods.Model.FoodModel

class CommentViewModel : ViewModel() {

   var mutableLiveDataCommentList:MutableLiveData<List<CommentModel>>?=null
    //private var mutableLiveDataComment:MutableLiveData<CommentModel>?=null

    init {
        mutableLiveDataCommentList = MutableLiveData()
    }

    fun setCommentList(commentList: List<CommentModel>)
    {
        mutableLiveDataCommentList!!.value = commentList
    }


}