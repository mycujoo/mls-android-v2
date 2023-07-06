package tv.mycujoo.mcls.tv

import android.os.Parcel
import android.os.Parcelable

@Suppress("DEPRECATION")
data class MCLSIMAParams(val data: HashMap<String, String>) : Parcelable {
    /**
     * Deprecation was introduced in API 33.
     */
    constructor(parcel: Parcel) : this(parcel.readSerializable() as HashMap<String, String>)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSerializable(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MCLSIMAParams> {
        override fun createFromParcel(parcel: Parcel): MCLSIMAParams {
            return MCLSIMAParams(parcel)
        }

        override fun newArray(size: Int): Array<MCLSIMAParams?> {
            return arrayOfNulls(size)
        }
    }
}