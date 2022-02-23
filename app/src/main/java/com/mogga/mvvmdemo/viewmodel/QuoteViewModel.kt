package com.mogga.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mogga.mvvmdemo.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuoteViewModel(private val quoteRepository: QuoteRepository):ViewModel() {

    fun getQuotes():LiveData<List<Quote>>{

        return quoteRepository.getQuotes()
    }

    fun insert(quote: Quote){

        GlobalScope.launch (Dispatchers.IO){
            quoteRepository.insert(quote)

        }
    }


}