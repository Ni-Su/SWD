package ru.stqa.litecart.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FirefoxNightlyTest {
    private WebDriver wd;
    private File logLocation;

    @BeforeMethod
    public void start() {
        //DesiredCapabilities caps = new DesiredCapabilities();
        //wd = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        wd = new FirefoxDriver(options);
        options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    @Test
    public void myFirstTest() {
        wd.navigate().to("http://www.google.com");
        wd.findElement(By.name("q")).sendKeys("webdriver");
        //wd.findElement(By.name("btnK")).click();
        //wait.until(titleIs("webdriver - Поиск в Google"));
        wd.get("http://localhost/litecart/admin/login.php");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
        wd.findElement(By.linkText("Catalog")).click();
        //wd.findElement(By.linkText("Add New Category")).click();
        //wd.findElement(By.name("save")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
    }
    @AfterMethod
    public void stop() {
        wd.quit();
        wd = null;
    }
    public boolean areElementPresent(By locator) {
        try {
            return  wd.findElements(locator).size() > 0;
        } catch (InvalidSelectorException ex) {
            return false;
        }
    }
}
