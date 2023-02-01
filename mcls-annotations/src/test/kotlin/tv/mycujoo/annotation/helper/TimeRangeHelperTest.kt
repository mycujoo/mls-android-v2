package tv.mycujoo.annotation.helper

import org.junit.Assert
import org.junit.Test
import tv.mycujoo.mclscore.Consts.ONE_SECOND_IN_MS

class TimeRangeHelperTest {
    @Test
    fun `given out of range timer-marker, should return false`() {
        Assert.assertFalse(TimeRangeHelper.isInRange(100F, 200))
        Assert.assertFalse(TimeRangeHelper.isInRange(189F, 200))
        Assert.assertFalse(TimeRangeHelper.isInRange(211F, 200))
    }

    @Test
    fun `given in range timer-marker, should return false`() {
        Assert.assertTrue(TimeRangeHelper.isInRange(200F, 200))
    }

    @Test
    fun `given lower range timer-marker, should return false`() {
        Assert.assertTrue(TimeRangeHelper.isInRange(190F, 200))
    }

    @Test
    fun `given higher range timer-marker, should return false`() {
        Assert.assertTrue(TimeRangeHelper.isInRange(210F, 200))
    }

    @Test
    fun `test isCurrentTimeInDvrWindowDuration()`() {
        Assert.assertTrue(
            TimeRangeHelper.isCurrentTimeInDvrWindowDuration(
                ONE_SECOND_IN_MS,
                1000000L
            )
        )
        Assert.assertTrue(TimeRangeHelper.isCurrentTimeInDvrWindowDuration(980000L, 1000000L))
        Assert.assertFalse(TimeRangeHelper.isCurrentTimeInDvrWindowDuration(981000L, 1000000L))
    }
}