package com.example.retrofitpractice;


import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnitRunner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.Call;

import static org.junit.Assert.assertEquals;

public class MainActivityTest2 extends AndroidJUnitRunner {
    String post;

    @Override
    public void onCreate(Bundle arguments) {
        MultiDex.install(getTargetContext());
        super.onCreate(arguments);
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void before() {
        mActivityTestRule.getActivity().getPosts();
    }

    @Test
    public void getPosts() {

        String h = "Coffeyville";

        //assertEquals(h, mActivityTestRule.getActivity().verify("Coffeyville"));

    }
}