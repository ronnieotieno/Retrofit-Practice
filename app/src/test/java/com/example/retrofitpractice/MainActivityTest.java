package com.example.retrofitpractice;


import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnitRunner;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTest extends AndroidJUnitRunner {
    @Override
    public void onCreate(Bundle arguments) {
        MultiDex.install(getTargetContext());
        super.onCreate(arguments);
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void getPosts() {

        String h = "Coffeyville";

        assertEquals(h, mActivityTestRule.getActivity().getPosts());

    }
}