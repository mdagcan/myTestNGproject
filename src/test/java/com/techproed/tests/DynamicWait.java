package com.techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicWait extends TestBase{
    @BeforeMethod
    public void setUp2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls"); Thread.sleep(5000);
    }
    @Test
    public void test1() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        String goneMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(goneMessage, "It's gone!");

        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        String backMassage = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(backMassage, "It's back!");
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click(); Thread.sleep(5000);
        WebElement enabledMessage = driver.findElement(By.id("message"));
        String enabledMessageText = enabledMessage.getText();
        Assert.assertEquals(enabledMessageText, "It's enabled!");
        //WebDriverWait wait = new WebDriverWait(driver,  20);
        //WebElement waitClickHere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

        driver.findElement(By.xpath("//button[normalize-space()='Disable']")).click(); Thread.sleep(5000);
        WebElement enabledMessage2 = driver.findElement(By.id("message"));
        String enabledMessageText2 = enabledMessage2.getText();
        Assert.assertEquals(enabledMessageText, "It's disabled!");

        //driver.findElement(By.xpath("//input[@type='text']")).click();
        //String yollananMetin = "mustafa dagcan";
        //driver.findElement(By.xpath("//input[@type='text']")).sendKeys(yollananMetin);
        //String backMessage2 = driver.findElement(By.xpath("//p[@id='message']")).getText();
        //Assert.assertEquals(backMessage2, "It's disabled!");
        //String yollanaMesajIcerigi = driver.findElement(By.xpath("//input[@type='text']")).getText();
        //Assert.assertEquals(yollanaMesajIcerigi,yollananMetin);
    }
}
