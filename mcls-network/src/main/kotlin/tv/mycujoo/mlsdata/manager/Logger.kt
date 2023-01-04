package tv.mycujoo.mlsdata.manager

import timber.log.Timber
import tv.mycujoo.mlsdata.enum.LogLevel
import tv.mycujoo.mlsdata.enum.LogLevel.*
import tv.mycujoo.mlsdata.enum.MessageLevel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Logger @Inject constructor(
    private var logLevel: LogLevel,
) {

    fun setLogLevel(logLevel: LogLevel) {
        this.logLevel = logLevel
    }

    fun getLogLevel(): LogLevel = logLevel

    fun log(messageLevel: MessageLevel, message: String?) {
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
            VERBOSE -> {
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
