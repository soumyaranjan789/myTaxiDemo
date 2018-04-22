package com.mytaxi.android_demo;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.core.internal.deps.protobuf.Internal;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class GivenTestForMyTaxi {
@Rule
    public ActivityTestRule<MainActivity> mActivityRule= new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;

    public static String userName= "whiteelephant261";
    public static String passWord="video1";
    public static String searchString="sa";
    public static String driverName="Sarah Friedrich";


    @Before
public void setActivity() {
    mActivity = mActivityRule.getActivity();
}

    @Test
    public void testLoginButton() throws Exception{
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_username)).perform(typeText(userName));
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_password)).perform(typeText(passWord));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(2000); // We can add Implicit wait here
        onView(withId(R.id.searchContainer)).check(matches(isDisplayed()));
        onView(withId(R.id.textSearch)).perform(click(),typeText(searchString),closeSoftKeyboard());
        onView(withText(driverName))
            .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
            .check(matches(isDisplayed())).perform(click());

        onView(withId(R.id.fab)).check(matches(isDisplayed()));
        onView(withId(R.id.fab)).perform(click());
    }


    }





