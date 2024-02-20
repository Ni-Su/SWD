package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogsTests {
    private WebDriver wd;
    private int i = 0;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void testLogs() {
        wd.get("http://localhost/litecart/admin/");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
        wd.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        //List<LogEntry> m = wd.manage().logs().get("browser").getAll();
        //System.out.println(m);
        wd.findElement(By.linkText("Rubber Ducks")).click();
        //wd.manage().logs().get("browser").forEach(l -> System.out.println(l));
        wd.findElement(By.linkText("Subcategory")).click();
        List<WebElement> products = wd.findElements(By.cssSelector("tbody td>a[href*=product]"));
        while (i <= products.size() -1) {
            //System.out.println(i);
            List<WebElement> pr = wd.findElements(By.cssSelector("tbody td>a[href*=product]"));
            pr.get(i).click();
            //System.out.println(wd.manage().logs().getAvailableLogTypes());
            for(LogEntry l : wd.manage().logs().get("browser").getAll()) {
                System.out.println(l);
                System.out.println("browser");
            }
            for(LogEntry l : wd.manage().logs().get("driver").getAll()) {
                System.out.println(l);
                System.out.println("driver");
            }
            for(LogEntry l : wd.manage().logs().get("client").getAll()) {
                System.out.println(l);
                System.out.println("client");
            }
            wd.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            wd.findElement(By.linkText("Rubber Ducks")).click();
            wd.findElement(By.linkText("Subcategory")).click();
            i = i +2;
        }

    }
    @AfterMethod
    public void tearDown(){wd.quit();}


}
