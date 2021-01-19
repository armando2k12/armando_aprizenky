package com.armando.armandoFoods.Callback

import com.armando.armandoFoods.Model.CategoryModel

interface ICategoryCallbackListener {
    fun onCategoryLoadSucess(categoriesList: List<CategoryModel>)
    fun onCategoryLoadFailed(message:String)
}