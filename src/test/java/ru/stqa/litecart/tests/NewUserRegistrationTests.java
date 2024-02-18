package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewUserRegistrationTests {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    private void testNewUserReg() {
        wd.get("http://localhost/litecart/en/");
        wd.findElement(By.linkText("New customers click here")).click();


    }
    @AfterMethod
    public void tearDown() {wd.quit();}
}
