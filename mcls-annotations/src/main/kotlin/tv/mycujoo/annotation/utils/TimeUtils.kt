package tv.mycujoo.annotation.utils

class TimeUtils {
    companion object {
        fun calculateOffset(
            windowAbsoluteStartTime: Long,
            actionAbsTime: Long
        ): Long {
            return actionAbsTime - windowAbsoluteStartTime
        }
    }
}
