package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
    @Test(priority = 1)
    public void login() {
        System.out.println("logintest");
        //Assert.assertTrue(false); // kastlı fail durumuna getirme
    }
    @Test(dependsOnMethods = "login")
    public void homePage() {
        System.out.println("home page test");
    }
    @Test(dependsOnMethods = "homePage")
    public void search() {
        System.out.println("search test");
    }
    @Test(dependsOnMethods = "search")
    public void resultTest() {
        System.out.println("result test");
    }
    @Test
    public void zoneControl() {
        System.out.println("zone en son olmalı");
    }
}
