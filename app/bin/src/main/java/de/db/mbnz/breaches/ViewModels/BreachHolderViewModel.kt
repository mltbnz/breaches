package de.db.mbnz.breaches.ViewModels

import de.db.mbnz.breaches.Models.Breach
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by mbnz on 12.11.17.
 */

final class BreachHolderViewModel(public val breach: Breach) {

    val domain: String
        get() {
            return if (breach.Domain.isBlank()) {
                "COULD NOT LOAD DOMAIN"
            } else {
                breach.Domain
            }
        }

    val title: String
        get() {
            return breach.Title
        }

    val name: String
        get() {
            return breach.Name
        }

    val breachDate: LocalDate
        get() {
            return LocalDate.parse(breach.BreachDate, DateTimeFormatter.ISO_DATE)
        }
}