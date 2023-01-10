package tv.mycujoo.mclscore.helper

import org.amshove.kluent.internal.assertEquals
import org.junit.Test
import java.util.*

class DateTimeHelperTest {

    @Test
    fun testParsing() {
        val cal = Calendar.getInstance()
        cal.set(2022, 11, 1, 6, 6, 6)

        println("${cal.time}")

        val result = DateTimeHelper.formatDatetime(cal, Locale.ENGLISH)

        assertEquals("01-12-2022 - 06:06", result)
    }
}