package com.example.imageloadertest.utils

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger


class TestUtils {
    companion object {
        val list50kb = listOf(
            "https://ts4.cn.mm.bing.net/th?id=OIP-C.EAh2ouiEzgzlSDyBlelJGwHaEo&pid=Api",//32kb
            "https://ts4.cn.mm.bing.net/th?id=OIP-C.oExo4MothsP3nghkOpvI2QHaEo&pid=Api",//23kb
            "https://tse1.explicit.bing.net/th?id=OIP-C.TTfIcxXZl3k-H1updf2OuQHaHa&pid=Api",//45kb
            "https://ts1.cn.mm.bing.net/th?id=OIP-C.wabYK6G2Jf1LoSl4MsRlmwHaHa&pid=Api",//43kb
            "https://ts3.cn.mm.bing.net/th?id=OIP-C.zzIBHZz9qTFNxpE7ExpOfwHaHa&pid=Api",//37kb
            "https://ts3.cn.mm.bing.net/th?id=OIP-C.jhJ8kKfG4GUbhpmLTS7kSQHaFj&pid=Api",//67kb
            "https://ts1.cn.mm.bing.net/th?id=OIP-C.-Vxl0UmafHpFWB2f76wMuQHaNK&pid=Api",//110kb
            "https://ts3.cn.mm.bing.net/th?id=OIP-C.a0smxDshvC_28svIRshQrAHaEK&pid=Api",//41.5kb
            "https://ts1.cn.mm.bing.net/th?id=OIP-C.MXJ2zgzehNQmy9o--9BRgQHaNJ&pid=Api",//78kb
            "https://ts3.cn.mm.bing.net/th?id=OIP-C.H51KC413BfVDuud0ClbpwQHaEK&pid=Api",//47kb
        )
    }

}