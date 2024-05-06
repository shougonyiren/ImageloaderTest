package com.example.imageloadertest;

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger
import com.example.imageloadertest.utils.CoilUtils

class MyApplication : Application(),
    ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
    }

    public override fun newImageLoader(): ImageLoader {
        //在这里可以自定义我们的CoilImageLoader
        return CoilUtils.newImageCacheLoader(applicationContext)
    }
}
