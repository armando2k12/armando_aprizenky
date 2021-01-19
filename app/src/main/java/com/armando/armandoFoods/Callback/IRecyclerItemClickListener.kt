package com.armando.armandoFoods.Callback

import android.view.View

interface IRecyclerItemClickListener {
    fun onItemClick(view:View,pos:Int)
}