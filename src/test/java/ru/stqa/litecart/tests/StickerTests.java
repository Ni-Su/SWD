package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickerTests {
    private WebDriver wd;
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSticker () throws Exception {
        wd.get("http://localhost/litecart/en/");
        List<WebElement> div = wd.findElements(By.cssSelector("div.content a.link"));
        for (WebElement l : div) {
            l.findElement(By.linkText("New"));
        }
    //есть три бокса
    //wd.findElement(By.id("box-most-popular");
    //в боксах есть товары
    //у каждого товара должен быть 1 стикер
    // <div class="sticker sale" title="On Sale">Sale</div>
    // <div class="sticker new" title="New">New</div>
    }

    @AfterMethod
    public void tearDown () {
        wd.quit();
    }
}
