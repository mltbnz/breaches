package de.db.mbnz.breaches.Models

import java.util.*

/**
 * Created by mbnz on 08.11.17.
 */

data class Breach(val name: String,
                  val title: String,
                  val domain: String,
                  val breachDate: String) {

    companion object Keys {
        val titleKey = "Title"
        val nameKey = "Name"
        val domainKey = "Domain"
        val breachDateKey = "BreachDate"
    }
}