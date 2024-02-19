package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NewWindowTests {
    private WebDriver wd;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        //wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, Duration.ofSeconds(5));
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
        List<WebElement> links = wd.findElements(By.cssSelector("tbody td tr a[href^=http][target]"));

        for(WebElement link : links) {
            String orginalWindow = wd.getWindowHandle();
            Set<String> existingWindows = wd.getWindowHandles();
            link.click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            wd.switchTo().window(newWindow);
            wd.close();
            wd.switchTo().window(orginalWindow);

        }

    }
    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver wd) {
                Set<String> habdles = wd.getWindowHandles();
                habdles.removeAll(oldWindows);
                return habdles.size() > 0 ? habdles.iterator().next():null;
            }
        };
    }
    @AfterMethod
    public void tearDown() { wd.quit(); }
}
