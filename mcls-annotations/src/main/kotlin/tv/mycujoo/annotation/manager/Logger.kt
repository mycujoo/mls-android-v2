package tv.mycujoo.annotation.manager

import tv.mycujoo.annotation.domain.enum.LogLevel
import tv.mycujoo.annotation.domain.enum.MessageLevel
import timber.log.Timber
import javax.inject.Inject


class Logger @Inject constructor(private var logLevel: LogLevel) {

    fun setLogLevel(logLevel: LogLevel) {
        this.logLevel = logLevel
    }

    fun getLogLevel(): LogLevel = logLevel

    fun log(messageLevel: MessageLevel, message: String?) {
        if (message == null) {
            return
        }
        when (logLevel) {
            LogLevel.MINIMAL -> {
                // do nothing
            }
            LogLevel.INFO -> {
                when (messageLevel) {
                    MessageLevel.VERBOSE,
                    MessageLevel.DEBUG -> {
                        // do nothing
                    }
                    MessageLevel.INFO -> {
                        Timber.tag("MLS-SDK").i(message)

                    }
                    MessageLevel.WARNING -> {
                        Timber.tag("MLS-SDK").w(message)

                    }
                    MessageLevel.ERROR -> {
                        Timber.tag("MLS-SDK").e(message)
                    }
                }
            }
            LogLevel.VERBOSE -> {
                when (messageLevel) {
                    MessageLevel.VERBOSE -> {
                        Timber.tag("MLS-SDK").v(message)
                    }
                    MessageLevel.DEBUG -> {
                        Timber.tag("MLS-SDK").d(message)
                    }
                    MessageLevel.INFO -> {
                        Timber.tag("MLS-SDK").i(message)

                    }
                    MessageLevel.WARNING -> {
                        Timber.tag("MLS-SDK").w(message)

                    }
                    MessageLevel.ERROR -> {
                        Timber.tag("MLS-SDK").e(message)
                    }
                }
            }
        }
    }
}
