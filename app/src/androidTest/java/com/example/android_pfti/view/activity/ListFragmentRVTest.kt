package com.example.android_pfti.view.activity


import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import childAtPosition
import com.example.android_pfti.R
import com.example.android_pfti.view.list_fragment.ListFragment
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ListFragmentRVTest {

    private lateinit var scenario: FragmentScenario<ListFragment>

    @Rule
    @JvmField
    var mGrantPermissionRule = GrantPermissionRule.grant(
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION")

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
    }

    @Test
    fun checkTextViewItem() {
        val textView = onView(allOf(withId(R.id.latlng_rv), withText("lat/lng: (90.0,151.0)"),
            withParent(withParent(withId(R.id.rv_list))), isDisplayed()))
        textView.check(ViewAssertions.matches(withText("lat/lng: (90.0,151.0)")))
    }

    @Test
    fun checkEditTextItemFirst() {
        val editText = onView(allOf(withId(R.id.name_rv), withText("First"),
            withParent(withParent(withId(R.id.rv_list))), isDisplayed()))
        editText.check(ViewAssertions.matches(withText("First")))
    }

    @Test
    fun editEditTextItemSecond() {
        val editText = onView(allOf(withId(R.id.name_rv), withText("Second"),
            childAtPosition(childAtPosition(withId(R.id.rv_list), 1), 1), isDisplayed()))
        editText.perform(click())
        editText.perform(replaceText("NewSecond"))
    }

    @Test
    fun editEditTextItemThird() {
        val editText = onView(allOf(withId(R.id.name_rv), withText("Third"), childAtPosition(
            childAtPosition(withId(R.id.rv_list),2), 1), isDisplayed()))
        editText.perform(replaceText("NewThird"))
    }

    @After
    fun clear() {
        scenario.recreate()
    }

}
