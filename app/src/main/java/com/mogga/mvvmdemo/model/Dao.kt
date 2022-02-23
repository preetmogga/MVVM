package com.mogga.mvvmdemo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Dao {


     @Query("SELECT * FROM quote")
    fun getQuote():LiveData<List<Quote>>

    @Insert
   suspend fun insert(quote: Quote)
}