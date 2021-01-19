package com.armando.armandoFoods.Callback

import com.armando.armandoFoods.Model.PopularCategoryModel

interface IPopularLoadCallback {
    fun onPopularLoadSucess(popularModelList: List<PopularCategoryModel>)
    fun onPopularLoadFailed(message:String)
}