package com.imcys.bilibilias.base.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.content.edit
import cn.jzvd.Jzvd
import com.imcys.bilibilias.R
import com.imcys.bilibilias.common.base.view.AsJzvdStd

class AppAsJzvdStd : AsJzvdStd {

    private val appAsJzStdPlayButton: ImageFilterView = findViewById(R.id.app_as_jz_std_play_bt)

    private val appAsJzStdDanmakuButton: ImageFilterView = findViewById(R.id.app_as_jz_std_danmu_bt)

    private val appAsJzStdLoadImage: ImageFilterView = findViewById(R.id.app_as_jz_std_load_image)

    @SuppressLint("Recycle")
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        if (!isInEditMode) {
            //弹幕按钮事件绑定
            bingAppAsJzStdDanmakuButtonEvent()
            //绑定播放按钮事件
            bindingAppAsJzStdPlayButtonEvent()
        }
    }

    constructor(context: Context) : super(context)


    private fun bindingAppAsJzStdPlayButtonEvent() {
        appAsJzStdPlayButton.setOnClickListener {
            when (state) {
                Jzvd.STATE_NORMAL, Jzvd.STATE_AUTO_COMPLETE -> {
                    //播放视频
                    startVideo()
                }

                Jzvd.STATE_PAUSE, Jzvd.STATE_PLAYING -> {
                    //恢复播放/暂停播放
                    startButton.performClick()
                }
            }
        }

    }


    private fun bingAppAsJzStdDanmakuButtonEvent() {
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

//        val danmakuSwitch =
//            sharedPreferences.getBoolean("user_video_danmaku_switch", true)

//        if (!danmakuSwitch) {
//            appAsJzStdDanmakuButton.setImageResource(com.imcys.bilibilias.common.R.drawable.ic_asplay_barrage_off)
//        }

        appAsJzStdDanmakuButton.setOnClickListener {
//            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

//            val danmakuSwitch =
//                sharedPreferences.getBoolean("user_video_danmaku_switch", true)

//            sharedPreferences.edit {
//                putBoolean("user_video_danmaku_switch", !danmakuSwitch)
//            }
            //注意，这里是变动前的标志
//            if (danmakuSwitch) {
//                appAsJzStdDanmakuButton.setImageResource(com.imcys.bilibilias.common.R.drawable.ic_asplay_barrage_off)
//            } else {
//                appAsJzStdDanmakuButton.setImageResource(com.imcys.bilibilias.common.R.drawable.ic_asplay_barrage_on)
//            }
        }
    }

    //预加载
    @SuppressLint("CheckResult")
    override fun onStatePreparing() {
        super.onStatePreparing()
        posterImageView.visibility = View.GONE
        asJzvdstdPosterFL.setBackgroundColor(resources.getColor(R.color.white))
        appAsJzStdLoadImage.visibility = View.VISIBLE

    }


    override fun getLayoutId(): Int {
        return R.layout.app_as_jz_layout_std
    }

    override fun onStatePlaying() {
        super.onStatePlaying()
        asJzvdstdPosterFL.setBackgroundColor(0x00000000)
        appAsJzStdLoadImage.visibility = View.GONE
        appAsJzStdPlayButton.setImageResource(R.drawable.ic_as_video_pause)
    }

    override fun onStatePause() {
        super.onStatePause()
        appAsJzStdPlayButton.setImageResource(R.drawable.ic_as_video_play)
    }

    override fun onStateAutoComplete() {
        super.onStateAutoComplete()
        appAsJzStdPlayButton.setImageResource(R.drawable.ic_as_video_redo)
    }

}