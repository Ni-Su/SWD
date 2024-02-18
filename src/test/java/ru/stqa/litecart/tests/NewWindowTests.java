package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewWindowTests {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void testNewWindow(){
        wd.get("http://localhost/litecart/admin/");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
        //wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        wd.findElement(By.linkText("Countries")).click();
        wd.findElement(By.linkText("Afghanistan")).click();

    }

    @AfterMethod
    public void tearDown() { wd.quit(); }
}
