package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddNewProductTests {
    private WebDriver wd;
    Path image;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAddNewProduct() {
        wd.get("http://localhost/litecart/admin/");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
        wd.findElement(By.linkText("Catalog")).click();
        List<WebElement> before = wd.findElements(By.cssSelector("tr.row"));
        wd.findElement(By.linkText("Add New Product")).click();
        wd.findElement(By.cssSelector("input[name*=name]")).sendKeys("Product from SWD");
        image = Path.of("SWD_image.PNG").toAbsolutePath();
        wd.findElement(By.cssSelector("input[name*=new_images")).sendKeys("D:\\SWD_image.PNG");
        wd.findElement(By.linkText("Information")).click();
        wd.findElement(By.cssSelector("input[name*=short")).sendKeys("автоматизация веб-проложений");
        wd.findElement(By.linkText("Prices")).click();
        wd.findElement(By.cssSelector("input[name*=purchase_price]")).clear();
        wd.findElement(By.cssSelector("input[name*=purchase_price]")).sendKeys("33");
        wd.findElement(By.cssSelector("span.input-wrapper [name*=USD]")).clear();
        wd.findElement(By.cssSelector("span.input-wrapper [name*=USD]")).sendKeys("33");
        wd.findElement(By.cssSelector("span.input-wrapper [name*=EUR]")).clear();
        wd.findElement(By.cssSelector("span.input-wrapper [name*=EUR]")).sendKeys("33");
        wd.findElement(By.name("save")).click();
        wd.findElement(By.linkText("Catalog")).click();
        List<WebElement> after =  wd.findElements(By.cssSelector("tr.row"));
        Assert.assertEquals(after.size(), before.size() + 1);
    }


    @AfterMethod
    public void tearDown() {wd.quit();}
}
