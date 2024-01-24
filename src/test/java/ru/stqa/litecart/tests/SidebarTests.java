package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        wd.findElement(By.linkText("Logotype")).click();

        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Product Groups")).click();
        wd.findElement(By.linkText("Option Groups")).click();
        wd.findElement(By.linkText("Manufacturers")).click();
        wd.findElement(By.linkText("Suppliers")).click();
        wd.findElement(By.linkText("Delivery Statuses")).click();
        wd.findElement(By.linkText("Sold Out Statuses")).click();
        wd.findElement(By.linkText("Quantity Units")).click();
        wd.findElement(By.linkText("CSV Import/Export")).click();

        wd.findElement(By.linkText("Countries")).click();

        wd.findElement(By.linkText("Currencies")).click();

        wd.findElement(By.linkText("Customers")).click();
        wd.findElement(By.linkText("CSV Import/Export")).click();
        wd.findElement(By.linkText("Newsletter")).click();

        wd.findElement(By.linkText("Geo Zones")).click();

        wd.findElement(By.linkText("Languages")).click();
        wd.findElement(By.linkText("Storage Encoding")).click();

        wd.findElement(By.linkText("Modules")).click();
        wd.findElement(By.linkText("Customer")).click();
        wd.findElement(By.linkText("Shipping")).click();
        wd.findElement(By.linkText("Payment")).click();
        wd.findElement(By.linkText("Order Total")).click();
        wd.findElement(By.linkText("Order Success")).click();
        wd.findElement(By.linkText("Order Action")).click();

        wd.findElement(By.linkText("Orders")).click();
        wd.findElement(By.linkText("Order Statuses")).click();

        wd.findElement(By.linkText("Pages")).click();

        wd.findElement(By.linkText("Reports")).click();
        wd.findElement(By.linkText("Most Sold Products")).click();
        wd.findElement(By.linkText("Most Shopping Customers")).click();

        wd.findElement(By.linkText("Settings")).click();
        wd.findElement(By.linkText("Defaults")).click();
        wd.findElement(By.linkText("General")).click();
        wd.findElement(By.linkText("Listings")).click();
        wd.findElement(By.linkText("Images")).click();
        wd.findElement(By.linkText("Checkout")).click();
        wd.findElement(By.linkText("Advanced")).click();
        wd.findElement(By.linkText("Security")).click();

        wd.findElement(By.linkText("Slides")).click();

        wd.findElement(By.linkText("Tax")).click();
        wd.findElement(By.linkText("Tax Rates")).click();

        wd.findElement(By.linkText("Translations")).click();
        wd.findElement(By.linkText("Scan Files")).click();
        wd.findElement(By.linkText("CSV Import/Export")).click();

        wd.findElement(By.linkText("Users")).click();

        wd.findElement(By.linkText("vQmods")).click();

    }
    @AfterMethod
    public void stop() {
        wd.quit();
        wd = null;
    }
}
