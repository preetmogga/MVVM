package com.mogga.mvvmdemo.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getDao():Dao
    companion object{
       private var INSTANCE : QuoteDatabase ? = null

        fun getDatabase(context: Context):QuoteDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                    QuoteDatabase::class.java,
                    "quote")
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }

    }


}