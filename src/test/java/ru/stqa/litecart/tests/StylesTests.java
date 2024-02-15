package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StylesTests {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testStyles() {
        wd.get("http://localhost/litecart/en/");
        String homeName = wd.findElement(By.cssSelector("div#box-campaigns li:first-child div.name")).getAttribute("innerText");
        String homeRegular = wd.findElement(By.cssSelector("div#box-campaigns li:first-child s.regular-price")).getAttribute("innerText");
        String homeDiscount = wd.findElement(By.cssSelector("div#box-campaigns li:first-child strong.campaign-price")).getAttribute("innerText");

        wd.findElement(By.cssSelector("div#box-campaigns a.link")).click();
        String pageName = wd.findElement(By.cssSelector("div#box-product h1")).getAttribute("innerText");
        String pageRegular = wd.findElement(By.cssSelector("div#box-product s.regular-price")).getAttribute("innerText");
        String pageDiscount = wd.findElement(By.cssSelector("div#box-product strong.campaign-price")).getAttribute("innerText");
        Assert.assertEquals(homeName, pageName);
        Assert.assertEquals(homeRegular, pageRegular);
        Assert.assertEquals(homeDiscount, pageDiscount);
    }

    @AfterMethod
    public void tearDown() { wd.quit(); }
}
