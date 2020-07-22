package com.example.maishameds

import androidx.recyclerview.widget.RecyclerView
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.hamcrest.core.Is
import org.hamcrest.core.IsNull
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class UILoadTest {
    @Rule
    @JvmField
    var mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkRecyclerView() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        onView(withId(R.id.postsRecyclerView)).check(matches(isDisplayed()))

        Thread.sleep(5000)
        val recycler_view: RecyclerView = mainActivity.getActivity().findViewById(R.id.postsRecyclerView)
        assertEquals(100,recycler_view.adapter?.itemCount!!)
    }
}