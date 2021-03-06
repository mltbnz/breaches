package de.db.mbnz.breaches.Models

import android.os.Parcelable
import java.io.Serializable
import java.util.*

/**
 * Created by mbnz on 08.11.17.
 */

data class Breach(
        val Name: String,
        val Title: String,
        val Domain: String,
        val BreachDate: String,
        val AddedDate: String,
        val ModifiedDate: String,
        val PwnCount: Int,
        val Description: String,
        val DataClasses: Array<String>,
        val IsVerified: Boolean,
        val OsFabricated: Boolean,
        val IsSensitive: Boolean,
        val IsActive: Boolean,
        val IsRetired: Boolean,
        val IsSpamList: Boolean): Serializable {

    companion object Keys {
        val titleKey = "Title"
        val nameKey = "Name"
        val domainKey = "Domain"
        val breachDateKey = "BreachDate"
    }
}