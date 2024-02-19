package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CatalogTests extends TestBase {
    private WebDriver wd;
    @BeforeMethod
    public void setUp() throws Exception{
        wd = new FirefoxDriver();
    }

    @Test
    public void testCatalog() throws Exception {
        wd.get("http://localhost/litecart/admin/login.php");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Add New Category")).click();
        wd.findElement(By.name("save")).click();
    }

}
