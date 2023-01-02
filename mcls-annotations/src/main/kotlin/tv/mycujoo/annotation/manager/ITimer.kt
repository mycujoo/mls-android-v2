package tv.mycujoo.annotation.manager

interface ITimer {

    fun getTime(): String
    fun start(startTimer: TimerEntity.StartTimer, now: Long)
    fun pause(pauseTimer: TimerEntity.PauseTimer, now: Long)
    fun adjust(adjustTimer: TimerEntity.AdjustTimer, now: Long)
    fun skip(skipTimer: TimerEntity.SkipTimer, now: Long)
}

