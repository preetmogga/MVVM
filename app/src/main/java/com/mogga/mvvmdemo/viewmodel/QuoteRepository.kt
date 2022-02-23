package com.mogga.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import com.mogga.mvvmdemo.model.Quote
import com.mogga.mvvmdemo.model.QuoteDatabase

class QuoteRepository(private val quoteDatabase: QuoteDatabase) {

    fun getQuotes():LiveData<List<Quote>>{

        return quoteDatabase.getDao().getQuote()
    }
     suspend fun insert(quote: Quote){
         quoteDatabase.getDao().insert(quote)
     }


}