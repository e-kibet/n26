package com.n26.network

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.io.Resources
import org.koin.dsl.module
import java.io.File

val fakeContext = module {
    single<Context> { ApplicationProvider.getApplicationContext() }
}

fun getJson(path: String): String {
    val uri = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}