package ru.stqa.litecart.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ChromeTest {
    private WebDriver wd;
    //private WebDriverWait wait;

    @BeforeMethod
    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //wait = new WebDriverWait(wd, 10);
    }
    @Test
    public void myFirstTest() {
        wd.navigate().to("http://www.google.com");
        wd.findElement(By.name("q")).sendKeys("webdriver");
        wd.findElement(By.name("btnK")).click();
        //wait.until(titleIs("webdriver - Поиск в Google"));
    }
    @AfterMethod
    public void stop() {
        wd.quit();
        wd = null;
    }

}
