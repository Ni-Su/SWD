package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddToCartTest {
    private WebDriver wd;
    private int items = 0;


    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testAddToCart(){
        //Duration tenSeconds = Duration.ofSeconds(10);
        //WebDriverWait wait = new WebDriverWait(wd, tenSeconds);
        wd.get("http://localhost/litecart/en/");
        wd.findElement(By.cssSelector("div#box-most-popular li.product:first-child")).click();
        while (items < 3 ) {
            System.out.println(isElementPresent(By.cssSelector("td.options>strong")));
            if(isElementPresent(By.cssSelector("td.options>strong"))) {
                Select size = new Select(wd.findElement(By.cssSelector("select")));
                size.selectByValue("Small");
                wd.findElement(By.cssSelector("button[name=add_cart_product]")).click();
                wd.findElement(By.linkText("Home")).click();
                wd.findElement(By.cssSelector("div#box-most-popular li.product:first-child")).click();
                //добавить выход из цикла if, заменить return
            }else {
                wd.findElement(By.cssSelector("button[name=add_cart_product]")).click();
                //wait.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("span.quantity"))));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            items = Integer.parseInt(wd.findElement(By.cssSelector("span.quantity")).getAttribute("innerText"));
            System.out.println(items);
            wd.findElement(By.linkText("Home")).click();
            wd.findElement(By.cssSelector("div#box-most-popular li.product:first-child")).click();
            }

        }
        wd.findElement(By.cssSelector("div#cart a.link")).click();
        while (isElementPresent(By.cssSelector("table.dataTable"))) {
            wd.findElement(By.cssSelector("button[value=Remove]")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Assert.assertTrue(isElementPresent(By.cssSelector("em")));
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
