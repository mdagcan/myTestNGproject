package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ifarmeTest extends TestBase{
    WebDriver driver; Actions actionObj;
    @BeforeMethod
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void isBoldedTextEditor() {
        WebElement boldedText = driver.findElement(By.xpath("//h3[contains(text(),'Editor')]"));
        Assert.assertTrue(boldedText.getText().contains("Editor"));
    }

    @Test
    public void iFrameTest() throws InterruptedException {

        driver.switchTo().frame("mce_0_ifr");
        WebElement textInFrame = driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']"));
        actionObj = new Actions(driver);
        actionObj.keyDown(Keys.CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.CONTROL).perform();
        textInFrame.sendKeys(Keys.chord(Keys.CONTROL, "a")+Keys.DELETE+"This text box is inside the frame"); Thread.sleep(3000);
    }

    @Test
    public void isElemantelSelenium() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Elemental Selenium"));
    }

}
