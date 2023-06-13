package me.soushin.tincompose.app

/**
 * 全局配置
 * @author SouShin
 * created at 2023/6/13 16:25
 */
class GlobalConfig private constructor(){

    companion object {
        private val instance: GlobalConfig by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            GlobalConfig()
        }
        @JvmStatic
        fun get() : GlobalConfig {
            return instance
        }
    }

    ///异常监听
    val errorHandler by lazy { ResponseErrorListenerImpl() }





}