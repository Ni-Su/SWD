package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickerShortTests {
    private WebDriver wd;
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSticker () throws Exception {
        wd.get("http://localhost/litecart/en/");
        List<WebElement> ducks = wd.findElements(By.cssSelector("div.content li.product"));

        for(WebElement duck : ducks) {
            List<WebElement> stickers = duck.findElements(By.cssSelector("div.sticker"));
            Assert.assertEquals(1, stickers.size());
        }
    }
    @AfterMethod
    public void tearDown () {
        wd.quit();
    }
}

