package ru.stqa.litecart.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortGeoZones {
    private WebDriver wd;
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testSortGeoZones() {
        wd.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();

        List<String> idsString = new ArrayList<String>();
        List<WebElement> ids = wd.findElements(By.cssSelector("form[name=geo_zones_form] tr.row td:nth-child(2)"));
        for (WebElement id : ids) {
            String idString = id.getAttribute("innerText");
            idsString.add(idString);
        }
        for (String pageNumber : idsString) {
            wd.get("http://localhost/litecart/admin/?app=geo_zones&doc=edit_geo_zone&page=1&geo_zone_id=" + pageNumber);
            List<WebElement> zones = wd.findElements(By.cssSelector("select[name*=zone_code] option[selected=selected]"));
            List<String> zonesStr = new ArrayList<String>();
            for (WebElement zona : zones) {
                String zonaStr = zona.getAttribute("innerText");
                zonesStr.add(zonaStr);
            }
            List<String> zonesSort = new ArrayList<>();
            zonesSort.addAll(zonesStr);
            Collections.sort(zonesSort);
            Assert.assertEquals(zonesStr, zonesSort);
        }
    }

    @AfterMethod
    public void tearDown() { wd.quit(); }
}
