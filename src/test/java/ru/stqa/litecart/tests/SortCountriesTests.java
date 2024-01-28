package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortCountriesTests {
    //Collections.sort(list);
    private WebDriver wd;
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void testSortCountries() {
        wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();

        List<String> countries = new ArrayList<>();
        List<WebElement> name = wd.findElements(By.cssSelector("table.dataTable a"));
        for(WebElement n : name) {
            String na = n.getAttribute("innerText");
            countries.add(na);
        }
        List<String> countriessort = new ArrayList<>();

    }
    @AfterMethod
    public void tearDown () {
        wd.quit();
    }
}
