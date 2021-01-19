package com.armando.armandoFoods.Callback


import com.armando.armandoFoods.Model.CommentModel

interface ICommentCallBackListener {
    fun onCommentLoadSucess(commentList: List<CommentModel>)
    fun onCommentLoadFailed(message:String)
}