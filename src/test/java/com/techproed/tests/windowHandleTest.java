package com.techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class windowHandleTest extends TestBase{
    @BeforeMethod
    public void setUpSmall() {
       driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void isOpeningTextHere() {
        String window1text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(window1text,"Opening a new window");
    }
    @Test
    public void isTitlehere() {
        String window1Title = driver.getTitle();
        Assert.assertEquals(window1Title, "The Internet");
    }
    @Test
    public void openingNewWindow()  {
        String window1Handle = driver.getWindowHandle();
        System.out.println(window1Handle);

        WebDriverWait wait = new WebDriverWait(driver,  20);
        WebElement waitClickHere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);

        for(String eachWindow:allWindowHandles) {
            System.out.println(eachWindow);
            driver.switchTo().window(eachWindow);
            System.out.println(driver.getTitle());
        }
        for(String eachWindow:allWindowHandles) {
            if (!eachWindow.equals(window1Handle)) {
                driver.switchTo().window(eachWindow);
            }
        }
        Assert.assertEquals(driver.getTitle(),"New Window");
    }




}
