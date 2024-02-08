package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
    public static int numberOfRow = 0;
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

        List<String> countries = new ArrayList<String>();
        List<WebElement> name = wd.findElements(By.cssSelector("tr.row>td:nth-child(5)"));
        for (WebElement n : name) {
            String na = n.getAttribute("innerText");
            countries.add(na);
        }
        List<String> cs = new ArrayList<>();
        cs.addAll(countries);
        Collections.sort(cs);
        Assert.assertEquals(countries, cs);

        List<String> codeCountries = new ArrayList<>();
        List<Integer> z = new ArrayList<Integer>();
        List<WebElement> zones = wd.findElements(By.cssSelector("tr.row>td:nth-child(6)"));
        for (WebElement n : zones) {
            int x = Integer.parseInt(n.getAttribute("innerText"));
            z.add(x);
        }

        List<WebElement> code = wd.findElements(By.cssSelector("tr.row>td:nth-child(4)"));
        for (int y : z) {
            if (y > 0) {
                String c;
                c = code.get(numberOfRow).getAttribute("innerText");
                codeCountries.add(c);
            }
            numberOfRow++;
        }

        for (String c : codeCountries) {
            wd.get("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=" + c);
            List<String> nameZones = new ArrayList<String>();
            List<WebElement> nz = wd.findElements(By.cssSelector("table#table-zones td:nth-child(3)"));
            for (WebElement tz : nz) {
                String timeZoneName = tz.getAttribute("innerText");
                if(! timeZoneName.equals("")) {nameZones.add(timeZoneName);}
            }
            List<String> nzs = new ArrayList<String>();
            nzs.addAll(nameZones);
            Collections.sort(nzs);
            Assert.assertEquals(nameZones, nzs);
        }
    }
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}