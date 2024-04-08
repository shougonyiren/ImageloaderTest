package common.adapter


import android.content.Context
import android.graphics.drawable.Drawable
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import com.blankj.utilcode.util.LogUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.imageloadertest.R
import com.example.imageloadertest.databinding.RcCommonImageBinding


/**

 * @Author : liuhao02

 * @Time : On 2024/1/10 10:01

 * @Description : ImageListAdapter

 */
class ImageListAdapter(data: List<String>) : BaseQuickAdapter<String, ImageListAdapter.VH>(data) {
    var imageLoader: ImageLoader? = null
    var isGlide: Boolean = false

    constructor(data: List<String>, imageLoader: ImageLoader, isGlide: Boolean) : this(data) {
        this.imageLoader = imageLoader;
        this.isGlide = isGlide
    }

    var listener: PictureClickListener? = null

    class VH(
        parent: ViewGroup,
        val binding: RcCommonImageBinding = RcCommonImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onBindViewHolder(holder: VH, position: Int, item: String?) {
        item?.let {
            var url = item
            var startTime: Long = 0
            var endTime: Long = 0
            startTime = SystemClock.uptimeMillis()
            if (isGlide) {
                Glide.with(context).load(item)
                    .into(object : CustomTarget<Drawable>() {
                        override fun onResourceReady(
                            resource: Drawable,
                            transition: Transition<in Drawable>?
                        ) {
                            endTime = SystemClock.uptimeMillis() // 获取结束时间
                            LogUtils.d(
                                "glide TestTime",
                                "onSuccess position: " + holder.bindingAdapterPosition + "  item:" + item + "   Runtime: " + (endTime - startTime)
                            )
                            holder.binding.image.setImageDrawable(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {

                        }

                    })
            } else {
                holder.binding.image.load(url) {
                    error(R.mipmap.ic_launcher)
                    target {
                        endTime = SystemClock.uptimeMillis() // 获取结束时间
                        LogUtils.d(
                            "coil TestTime",
                            "onSuccess position: " + holder.bindingAdapterPosition + "  item:" + item + "   Runtime: " + (endTime - startTime)
                        )
                        holder.binding.image.setImageDrawable(it)
                    }
//                listener(
//                    onStart = { request ->
//                        startTime = SystemClock.uptimeMillis()
//                        LogUtils.d("TestTime", "onStart networkThumbnail$startTime")
//                    },
//                    onError = { request, throwable ->
//                        endTime = SystemClock.uptimeMillis() // 获取结束时间
//                        LogUtils.d(
//                            "TestTime",
//                            "onError item:" + item + "Runtime: " + (endTime - startTime) + "throwable: " + throwable.throwable.toString()
//                        )
//                    },
//                    onCancel = {
//                        endTime = SystemClock.uptimeMillis() // 获取结束时间
//                        LogUtils.d(
//                            "TestTime",
//                            "onCancel item:" + item + "Runtime: " + (endTime - startTime)
//                        )
//                    },
//                    onSuccess = { request, metadata ->
//                        endTime = SystemClock.uptimeMillis() // 获取结束时间
//                        LogUtils.d(
//                            "TestTime",
//                            "onSuccess  item:" + item + "Runtime: " + (endTime - startTime)
//                        )
//                    }
//                )
                }
            }
            holder.binding.image.setOnClickListener {
                listener?.onClick(item, position)
            }
        }
    }

//    fun getMImageLoader(): ImageLoader {
//        if (imageLoader != null) {
//            return imageLoader!!
//        } else {
//            return context.imageLoader
//        }
//    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): ImageListAdapter.VH {
        return VH(parent)
    }

    fun setPictureClickListener(addListener: PictureClickListener) {
        this.listener = addListener
    }

    interface PictureClickListener {
        fun onClick(path: String, position: Int)
    }
}