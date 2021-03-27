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
package com.n26.presentation.ui.adapter

import com.robinhood.spark.SparkAdapter

class ChatAdapter : SparkAdapter() {
    private val testData = listOf(
        1.11f, 2.11f, 0.0001f, 0.2f, 2.1f, 1.11f, 2.11f, 0.0001f, 0.2f, 2.1f
    )

    override fun getCount(): Int = testData.size

    override fun getItem(index: Int): Float = testData[index]

    override fun getY(index: Int): Float = testData[index]
}