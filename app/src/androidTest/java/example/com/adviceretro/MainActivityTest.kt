package example.com.adviceretro

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
class MainActivityTest : TestCase() {


    @Test
    fun testbed1(){
       // onView(
      //      withId(R.id.textViewQuote)).check(Text)

        assertFalse(withId(R.id.textViewQuote).matches("Hello World"))
    }
}