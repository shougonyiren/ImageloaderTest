package com.example.imageloadertest.utils

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger

class CoilUtils {

    companion object {
        fun newImageCacheLoader(context: Context): ImageLoader {
            //在这里可以自定义我们的ImageLoader
            return ImageLoader(context).newBuilder()
                .memoryCachePolicy(CachePolicy.ENABLED)//开启内存缓存策略
                .memoryCache {//构建内存缓存
                    MemoryCache.Builder(context)
                        .maxSizePercent(0.1)//最大只能使用剩余内存空间的10%
                        .strongReferencesEnabled(true)//开启强引用
                        .build()
                }
                .diskCachePolicy(CachePolicy.ENABLED)//开启磁盘缓存策略
                .diskCache { //构建磁盘缓存
                    DiskCache.Builder()
                        .maxSizePercent(0.03)//最大只能使用剩余内存空间的3%
                        .directory(context.cacheDir)//存放在缓存目录
                        .build()
                }
                .logger(DebugLogger())//开启调试记录
                .build()
        }

        fun newNoCacheLoader(context: Context): ImageLoader {
            //在这里可以自定义我们的ImageLoader
            return ImageLoader(context).newBuilder()
                .memoryCachePolicy(CachePolicy.DISABLED)//关闭内存缓存策略
                .diskCachePolicy(CachePolicy.DISABLED)//关闭磁盘缓存策略
//                .logger(DebugLogger())//开启调试记录
                .build()
        }

        fun newImageMemoryCacheLoader(context: Context): ImageLoader {
            //在这里可以自定义我们的ImageLoader
            return ImageLoader(context).newBuilder()
                .memoryCachePolicy(CachePolicy.DISABLED)//开启内存缓存策略
                .memoryCache {//构建内存缓存
                    MemoryCache.Builder(context)
                        .maxSizePercent(0.1)//最大只能使用剩余内存空间的10%
                        .strongReferencesEnabled(true)//开启强引用
                        .build()
                }
                .logger(DebugLogger())//开启调试记录
                .build()
        }
    }

}