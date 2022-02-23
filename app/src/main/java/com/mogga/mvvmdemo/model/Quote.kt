package com.mogga.mvvmdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val author:String,
    val text:String
)
