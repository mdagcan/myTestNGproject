package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeClass
    public void setUpClass () {
        System.out.println("Before Class avtive");
    }
    @BeforeTest
    public void setUpTest () {
        System.out.println("Before Test active");
    }
    @BeforeMethod
    public void setUp () {
        System.out.println("Before Method active");
    }
    @AfterMethod
    public void tearDown ()  {
        System.out.println("After Method active");
    }
    @Ignore
    @Test(priority = 2,dependsOnMethods = "test3")
    public void test1 () {
        System.out.println("Test 1 activated");
    }

    @Test(priority = 3)
    public void test2 () {
        System.out.println("Test 2 activated");
    }

    @Test(priority = 1)
    public void test3 () {
        System.out.println("Test 3 activated");
    }

    @Test(priority = 4-15)
    public void test4 () {
        System.out.println("Test 4 activated");
    }
}
