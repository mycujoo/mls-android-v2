package tv.mycujoo.mclscore.logger

import android.util.Log
import tv.mycujoo.mclscore.logger.LogLevel.*

class Logger constructor(
    private var logLevel: LogLevel = MINIMAL,
) {

    fun setLogLevel(logLevel: LogLevel) {
        this.logLevel = logLevel
    }

    fun getLogLevel(): LogLevel = logLevel

    fun log(messageLevel: MessageLevel, message: String?, tag: String = TAG) {
        if (message == null) {
            return
        }
        when (logLevel) {
            MINIMAL -> {
                // do nothing
            }
            INFO -> {
                when (messageLevel) {
                    MessageLevel.VERBOSE,
                    MessageLevel.DEBUG -> {
                        // do nothing
                    }
                    MessageLevel.INFO -> {
                        Log.v(tag, message)

                    }
                    MessageLevel.WARNING -> {
                        Log.w(tag, message)

                    }
                    MessageLevel.ERROR -> {
                        Log.e(tag, message)
                    }
                }
            }
            VERBOSE -> {
                when (messageLevel) {
                    MessageLevel.VERBOSE -> {
                        Log.v(tag, message)
                    }
                    MessageLevel.DEBUG -> {
                        Log.d(tag, message)
                    }
                    MessageLevel.INFO -> {
                        Log.i(tag, message)
                    }
                    MessageLevel.WARNING -> {
                        Log.w(tag, message)
                    }
                    MessageLevel.ERROR -> {
                        Log.e(tag, message)
                    }
                }
            }
        }
    }

    companion object {
        const val TAG = "MCLS-SDK"
    }

    fun v(message: String?, tag: String = "") {
        log(
            tag = "MCLS-SDK: $tag",
            messageLevel = MessageLevel.VERBOSE,
            message = message,
        )
    }

    fun d(message: String?, tag: String = "") {
        log(
            tag = "MCLS-SDK: $tag",
            messageLevel = MessageLevel.DEBUG,
            message = message,
        )
    }

    fun i(message: String?, tag: String = "") {
        log(
            tag = "MCLS-SDK: $tag",
            messageLevel = MessageLevel.INFO,
            message = message,
        )
    }

    fun w(message: String?, tag: String = "") {
        log(
            tag = "MCLS-SDK: $tag",
            messageLevel = MessageLevel.WARNING,
            message = message,
        )
    }

    fun e(message: String?, tag: String = "") {
        log(
            message = message,
            tag = "MCLS-SDK: $tag",
            messageLevel = MessageLevel.ERROR
        )
    }
}
