package tv.mycujoo.mclsplayer.player.logger

import timber.log.Timber
import javax.inject.Inject
import tv.mycujoo.mclsplayer.player.entity.LogLevel
import tv.mycujoo.mclsplayer.player.entity.MessageLevel

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
