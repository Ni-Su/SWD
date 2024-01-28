package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SidebarTests {
    private WebDriver wd;

    @BeforeMethod
    public void start () {
        FirefoxOptions options = new FirefoxOptions();
        wd = new FirefoxDriver(options);
        options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @Test
    public void myFirstTest () {
        wd.navigate().to("http://www.google.com");
        wd.findElement(By.name("q")).sendKeys("webdriver");
        //wd.findElement(By.name("btnK")).click();
        //wait.until(titleIs("webdriver - Поиск в Google"));
        wd.get("http://localhost/litecart/admin/login.php");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();

        List<String> charters = new ArrayList<>();
        List<WebElement> span = wd.findElements(By.cssSelector("span.name"));
        for (WebElement element : span) {
            String chapter = element.getText();
            charters.add(chapter);
        }
        for (String ch : charters) {
            wd.findElement(By.linkText(ch)).click();
            List<WebElement> li = wd.findElements(By.cssSelector("[id *= doc]"));
            List<String> subsections = new ArrayList<>();
            for (WebElement element1 : li) {
                String subsection = element1.getText();
                subsections.add(subsection);
            }
            for (String ss : subsections) {
                wd.findElement(By.linkText(ss)).click();
                Assert.assertTrue(areElementPresent(By.tagName("h1")));
            }
        }
    }

    @AfterMethod
    public void stop () {
        wd.quit();
        wd = null;
    }

    public boolean areElementPresent (By locator) {
        try {
            return wd.findElements(locator).size() > 0;
        } catch (InvalidSelectorException ex) {
            return false;
        }
    }
}





