package tv.mycujoo.annotation.helper


import android.graphics.Typeface
import com.caverock.androidsvg.SVGExternalFileResolver
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Implementation to SVGExternalFileResolver which is required by AndroidSVG library, in order to parse custom fonts.
 * @see SVGExternalFileResolver
 */
class SVGAssetResolver @Inject constructor(
    private val typeFaceFactory: ITypeFaceFactory
) : SVGExternalFileResolver() {

    override fun resolveFont(
        fontFamily: String?,
        fontWeight: Int,
        fontStyle: String?
    ): Typeface? {
        return try {
            if (fontFamily == null) {
                return null
            }

            //Important! lower case the font name as name of font files can NOT be upper case in assets
            val lowerCasedFontName = fontFamily.lowercase(Locale.ENGLISH)
            if (lowerCasedFontName.contains(ROBOTO_MONO_BOLD)) {
                return if (TYPEFACE_ROBOTO_MONO_BOLD == null) {
                    TYPEFACE_ROBOTO_MONO_BOLD =
                        typeFaceFactory.createFromAsset(ROBOTO_MONO_BOLD_FILE_NAME)
                    TYPEFACE_ROBOTO_MONO_BOLD
                } else {
                    TYPEFACE_ROBOTO_MONO_BOLD
                }
            }
            if (lowerCasedFontName.contains(ROBOTO_MONO_REGULAR)) {
                return if (TYPEFACE_ROBOTO_MONO_REGULAR == null) {
                    TYPEFACE_ROBOTO_MONO_REGULAR =
                        typeFaceFactory.createFromAsset(ROBOTO_MONO_REGULAR_FILE_NAME)
                    TYPEFACE_ROBOTO_MONO_REGULAR
                } else {
                    TYPEFACE_ROBOTO_MONO_REGULAR
                }
            }
            if (lowerCasedFontName.contains(NOTO_SANS_MONO_EXTRA_CONDENSED)) {
                return if (TYPEFACE_NOTO_SANS_MONO_EXTRA_CONDENSED == null) {
                    TYPEFACE_NOTO_SANS_MONO_EXTRA_CONDENSED =
                        typeFaceFactory.createFromAsset(NOTO_SANS_MONO_EXTRA_CONDENSED_FILE_NAME)
                    TYPEFACE_NOTO_SANS_MONO_EXTRA_CONDENSED
                } else {
                    TYPEFACE_NOTO_SANS_MONO_EXTRA_CONDENSED
                }
            }
            return null


        } catch (ignored: RuntimeException) {
            null
        }
    }

    companion object {
        /**
         * Name of fonts and their related files, including the types (.ttf) in asset directory
         */
        const val ROBOTO_MONO_BOLD = "robotomono-bold"
        const val ROBOTO_MONO_REGULAR = "robotomono-regular"
        const val ROBOTO_MONO_BOLD_FILE_NAME = "robomono-b.ttf"
        const val ROBOTO_MONO_REGULAR_FILE_NAME = "robomono-r.ttf"

        const val NOTO_SANS_MONO_EXTRA_CONDENSED = "noto sans mono extracondensed"
        const val NOTO_SANS_MONO_EXTRA_CONDENSED_FILE_NAME = "notosansmonoextracondensed-r.ttf"

        private var TYPEFACE_ROBOTO_MONO_BOLD: Typeface? = null
        private var TYPEFACE_ROBOTO_MONO_REGULAR: Typeface? = null
        private var TYPEFACE_NOTO_SANS_MONO_EXTRA_CONDENSED: Typeface? = null
    }
}
