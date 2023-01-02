package tv.mycujoo.annotation.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThreadUtils @Inject constructor() {
    fun getScheduledExecutorService(): ScheduledExecutorService {
        return Executors.newScheduledThreadPool(1)
    }

    fun provideHandler(): Handler {
        return Handler(Looper.myLooper() ?: Looper.getMainLooper())
    }
}