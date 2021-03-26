/*
 * Copyright 2021 N26
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.n26.network.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class StatisticsWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        TODO(
            "Implement fetching of statistics." +
                " The data from https://api.blockchain.info/stats is updated at intervals of 7 minutes" +
                "Ideally we should get that from the api and persist then we can do a chart for the same "
        )
    }
}