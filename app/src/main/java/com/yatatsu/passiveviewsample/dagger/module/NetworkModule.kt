package com.yatatsu.passiveviewsample.dagger.module

import android.content.Context

import com.squareup.okhttp.Cache
import com.squareup.okhttp.OkHttpClient
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso
import com.yatatsu.passiveviewsample.dagger.scope.ApplicationScope

import java.io.File

import dagger.Module
import dagger.Provides

/**
 * NetworkModule
 */
@Module
open class NetworkModule {

  @ApplicationScope
  @Provides
  open fun provideOkHttpClient(context: Context): OkHttpClient {
    val cacheFile = File(context.cacheDir, "okhttp.cache")
    val cache = Cache(cacheFile, 4 * 1024 * 1024.toLong())
    val okHttpClient = OkHttpClient()
    okHttpClient.cache = cache
    return okHttpClient
  }

  @ApplicationScope
  @Provides
  fun providePicasso(context: Context, okHttpClient: OkHttpClient): Picasso {
    val downloader = OkHttpDownloader(okHttpClient)
    val picasso = Picasso.Builder(context).downloader(downloader).build()
    Picasso.setSingletonInstance(picasso)
    return Picasso.with(context)
  }
}
