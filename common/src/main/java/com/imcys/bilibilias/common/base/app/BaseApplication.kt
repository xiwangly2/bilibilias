package com.imcys.bilibilias.common.base.app

import android.app.Application
import android.content.Context
import android.os.Handler
import androidx.preference.PreferenceManager
import com.baidu.mobstat.StatService
import com.imcys.bilibilias.common.BuildConfig
import com.imcys.bilibilias.common.base.model.user.MyUserData
import com.liulishuo.okdownload.OkDownloadProvider.context
import com.tencent.mmkv.MMKV
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config
import com.xiaojinzi.component.impl.application.ModuleManager

open class BaseApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        handler = Handler(mainLooper)

        //百度统计开始
        startBaiDuService()

        initKComponent()

        //初始化MMKV
        initMMKV()

    }

    private fun initMMKV() {
        MMKV.initialize(this)
        dataKv = MMKV.mmkvWithID("data")
    }

    private fun initKComponent() {
        Component.init(
            application = this,
            isDebug = BuildConfig.DEBUG,
            config = Config.Builder()
                .build()
        )
        // 手动加载模块
        ModuleManager.registerArr(
            "app", "common", "tool_livestream", "tool_log_export"
        )
    }


    /**
     * 百度统计
     */
    private fun startBaiDuService() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val authorizedState = sharedPreferences.getBoolean("baidu_statistics_type", false)
        StatService.setAuthorizedState(applicationContext, authorizedState)
        StatService.autoTrace(applicationContext)
    }


    companion object {

        const val appSecret = "3c7c5174-a6be-4093-a0df-c6fbf7371480"
        const val AppGuideVersion = "1.0"


        //全局应用数据的MMKV
        lateinit var dataKv: MMKV
            private set

        //——————————————————全局线程处理器——————————————————
        lateinit var handler: Handler
            private set
        //—————————————————————————————————————————————————

        //——————————————————B站视频模板——————————————————

        const val roamApi: String = "https://api.bilibili.com/"

        //——————————————————部分内置需要的上下文——————————————————

        private var instance: BaseApplication? = null
        @JvmStatic
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        var mid: Long = 0
        lateinit var myUserData: MyUserData.DataBean
        //—————————————————————————————————————————————————


    }
}