package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SidebarTests {
    private WebDriver wd;
    private File logLocation;

    @BeforeMethod
    public void start() {
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

        wd.findElement(By.linkText("Appearence")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Logotype")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Catalog")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Product Groups")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Option Groups")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Manufacturers")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Suppliers")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Delivery Statuses")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Sold Out Statuses")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Quantity Units")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("CSV Import/Export")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Countries")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Currencies")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Customers")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("CSV Import/Export")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Newsletter")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Geo Zones")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Languages")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Storage Encoding")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Modules")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Customer")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Shipping")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Payment")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Order Total")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Order Success")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Order Action")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Orders")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Order Statuses")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Pages")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Reports")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Most Sold Products")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Most Shopping Customers")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Settings")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Defaults")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("General")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Listings")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Images")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Checkout")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Advanced")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Security")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Slides")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Tax")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Tax Rates")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Translations")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("Scan Files")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));
        wd.findElement(By.linkText("CSV Import/Export")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("Users")).click();
        Assert.assertTrue(areElementPresent(By.tagName("h1")));

        wd.findElement(By.linkText("vQmods")).click();
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
