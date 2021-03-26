package com.n26.presentation.ui.adapter

import com.robinhood.spark.SparkAdapter

class ChatAdapter: SparkAdapter() {
    private val testData = listOf(
        1.11f,2.11f,0.0001f,0.2f,2.1f, 1.11f,2.11f,0.0001f,0.2f,2.1f
    )
    override fun getCount(): Int = testData.size

    override fun getItem(index: Int): Float  = testData[index]

    override fun getY(index: Int): Float = testData[index]
}