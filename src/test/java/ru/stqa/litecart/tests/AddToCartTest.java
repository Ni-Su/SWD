package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AddToCartTest {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testAddToCart(){
        wd.get("http://localhost/litecart/en/");
        wd.findElement(By.cssSelector("div#box-most-popular li.product:first-child")).click();
        wd.findElement(By.cssSelector("td.options>strong"));
        if(isElementPresent(By.cssSelector("td.options>strong"))) {
            Select size = new Select(wd.findElement(By.cssSelector("select")));
            size.selectByValue("Small");
        }
        wd.findElement(By.cssSelector("button[name=add_cart_product]")).click();




    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterMethod
    public void tearDown() { wd.quit(); }
}
