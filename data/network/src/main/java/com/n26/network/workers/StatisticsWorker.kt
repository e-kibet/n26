package com.n26.network.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class StatisticsWorker (context : Context, params : WorkerParameters): Worker(context, params){
    override fun doWork(): Result {
        TODO("Implement fetching of statistics." +
                " The data from https://api.blockchain.info/stats is updated at intervals of 7 minutes" +
                "Ideally we should get that from the api and persist then we can do a chart for the same ")
    }
}