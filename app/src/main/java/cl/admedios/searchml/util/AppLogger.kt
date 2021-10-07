package cl.admedios.searchml.util

import android.util.Log
import cl.admedios.searchml.BuildConfig

class AppLogger {

    companion object : LogLevels() {
        //private var crashlytics = FirebaseCrashlytics.getInstance()

        override fun v(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.v(tag, message)
            }
            //crashlytics.log(message)
        }

        override fun i(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.i(tag, message)
            }
            //crashlytics.log(message)
        }

        override fun d(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
            //crashlytics.log(message)
        }

        override fun d(tag: String, message: String, e: Throwable) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, message, e)
            }
            //crashlytics.log(message)
        }

        override fun e(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, message)
            }
            //crashlytics.log(message)
        }

        override fun e(tag: String, message: String, e: Throwable) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, message, e)
            }
            //FirebaseCrashlytics.getInstance().recordException(e)
        }

        override fun w(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.w(tag, message)
            }
            //crashlytics.log(message)
        }

        override fun w(tag: String, message: String, e: Throwable) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, message, e)
            }
            //crashlytics.log(message)
        }
    }
}

abstract class LogLevels {
    abstract fun v(tag: String, message: String)
    abstract fun i(tag: String, message: String)
    abstract fun d(tag: String, message: String)
    abstract fun d(tag: String, message: String, e: Throwable)
    abstract fun e(tag: String, message: String)
    abstract fun e(tag: String, message: String, e: Throwable)
    abstract fun w(tag: String, message: String)
    abstract fun w(tag: String, message: String, e: Throwable)
}