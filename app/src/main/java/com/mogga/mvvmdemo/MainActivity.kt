package com.mogga.mvvmdemo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mogga.mvvmdemo.databinding.ActivityMainBinding
import com.mogga.mvvmdemo.model.Quote
import com.mogga.mvvmdemo.model.QuoteDatabase
import com.mogga.mvvmdemo.viewmodel.QuoteRepository
import com.mogga.mvvmdemo.viewmodel.QuoteViewModel
import com.mogga.mvvmdemo.viewmodel.QuotesViewModelFactory

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        val quoteRepository = QuoteRepository(quoteDatabase)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        quoteViewModel = ViewModelProvider(this,QuotesViewModelFactory(quoteRepository)).get(QuoteViewModel::class.java)
        quoteViewModel.getQuotes().observe(this, {
            binding.quotes = it.toString()
        })
        binding.addQuotes.setOnClickListener {
            val quote = Quote(0,"testing","this is tesing")
            quoteViewModel.insert(quote)

        }




    }
}