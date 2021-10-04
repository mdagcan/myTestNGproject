package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class googleSoftAssert {
    WebDriver driver;
    @BeforeMethod
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER); Thread.sleep(1000);
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("porcelain teapot"),"porcelain tea pot"); //  eleman yoksa mesaj görünür
        System.out.println("This is after HARD ASSERT");// eleman varsa burası yazdırılır
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pageTitle.contains("teapot"),"///////////////////");

        softAssert.assertTrue(pageTitle.contains("porce lain"),"******************");

        softAssert.assertTrue(pageTitle.contains("porca"),"===================");

        softAssert.assertAll("soft Assert HATA TESPİT ETTİ");
    }
}
