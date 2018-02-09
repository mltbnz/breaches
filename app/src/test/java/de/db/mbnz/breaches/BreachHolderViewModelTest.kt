package de.db.mbnz.breaches

import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.ViewModels.BreachHolderViewModel
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Created by mbnz on 09.02.18.
 */

class BreachHolderViewModelTest() {

    val breach = Breach("TheFlyOnTheWall",
            "the Fly on the Wall",
            "theflyonthewall.com",
            "2017-12-31",
            "2018-01-15T06:42:31Z",
            "2018-01-15T06:42:31Z",
            84011,
            "In December 2017",
            arrayOf("42", "232"),
            true,
            false,
            false,
            true,
            false,
            false)

    @Test
    fun testDomainReturnsIfItWasSet() {
        //given
        val objectUnderTest = BreachHolderViewModel(breach)
        //when
        val result = objectUnderTest.domain
        //then
        Assert.assertEquals(result, "theflyonthewall.com")
    }

    @Test
    fun testBreachDate() {
        //given
        val objectUnderTest = BreachHolderViewModel(breach)
        //when
        val result = objectUnderTest.breachDate
        val testDate = LocalDate.parse(breach.BreachDate, DateTimeFormatter.ISO_DATE)
        //then
        Assert.assertEquals(objectUnderTest.breachDate, testDate)
    }
}