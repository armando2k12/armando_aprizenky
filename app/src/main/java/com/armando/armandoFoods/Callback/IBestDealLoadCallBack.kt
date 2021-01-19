package com.armando.armandoFoods.Callback

import com.armando.armandoFoods.Model.BestDealModel
import com.armando.armandoFoods.Model.PopularCategoryModel

interface IBestDealLoadCallBack {
    fun onBestDealLoadSucess(bestDealList: List<BestDealModel>)
    fun onBestDealLoadFailed(message:String)
}