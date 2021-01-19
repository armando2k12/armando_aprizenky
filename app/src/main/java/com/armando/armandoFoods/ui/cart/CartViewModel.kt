package com.armando.armandoFoods.ui.cart

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armando.armandoFoods.Common.Common
import com.armando.armandoFoods.Database.CartDataSource
import com.armando.armandoFoods.Database.CartDatabase
import com.armando.armandoFoods.Database.CartItem
import com.armando.armandoFoods.Database.LocalCartDataSource
import com.armando.armandoFoods.Model.CommentModel
import com.armando.armandoFoods.Model.FoodModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CartViewModel : ViewModel() {

    private val compositeDisposable:CompositeDisposable
    private var cartDatasource: CartDataSource?=null
    private var mutableLiveDataCartItem:MutableLiveData<List<CartItem>>?=null

    init {
        compositeDisposable = CompositeDisposable()
    }

    fun initCartdataSource(context: Context){
        cartDatasource = LocalCartDataSource(CartDatabase.getInstance(context).cartDao())
    }

    fun getMutableLiveDataCartItem():MutableLiveData<List<CartItem>>{
        if (mutableLiveDataCartItem == null)
            mutableLiveDataCartItem = MutableLiveData()
        getCartItems()
        return mutableLiveDataCartItem!!
    }
    private fun getCartItems(){
        compositeDisposable.addAll(cartDatasource!!.getAllCart(Common.currentUser!!.uid!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ cartItems->

                mutableLiveDataCartItem!!.value = cartItems
            },{t: Throwable? -> mutableLiveDataCartItem!!.value = null}))

    }
    fun onStop(){
        compositeDisposable.clear()
    }
}