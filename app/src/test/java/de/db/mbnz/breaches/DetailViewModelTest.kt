package de.db.mbnz.breaches

import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.ViewModels.DetailViewModel
import org.junit.Assert
import org.junit.Test

/**
 * Created by mbnz on 08.02.18.
 */

class DetailViewModelTest {

    val b = Breach("TheFlyOnTheWall",
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
    fun initShouldSetBreachesProperty() {
        //given
        val objectUnderTest = DetailViewModel(b)
        //when
        val result = objectUnderTest.breach
        //then
        Assert.assertNotNull(result)
    }

    @Test
    fun testTitleReturnsCapitalizedTitle() {
        //given
        val objectUnitTest = DetailViewModel(b)
        //when
        val result = objectUnitTest.title
        val firstChar = result[0]
        //then
        Assert.assertTrue(firstChar == "T".first())
    }
}