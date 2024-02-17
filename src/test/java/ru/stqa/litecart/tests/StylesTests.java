package ru.stqa.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StylesTests {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        //wd = new ChromeDriver();
        //wd = new EdgeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testStyles() {
        wd.get("http://localhost/litecart/en/");
        String homeName = wd.findElement(By.cssSelector("div#box-campaigns li:first-child div.name")).getAttribute("innerText");
        String homeRegular = wd.findElement(By.cssSelector("div#box-campaigns li:first-child s.regular-price")).getAttribute("innerText");
        String homeDiscount = wd.findElement(By.cssSelector("div#box-campaigns li:first-child strong.campaign-price")).getAttribute("innerText");
        WebElement hrp = wd.findElement(By.cssSelector("div#box-campaigns li:first-child s.regular-price"));
        WebElement hdp = wd.findElement(By.cssSelector("div#box-campaigns li:first-child strong.campaign-price"));

        String colorhrp = hrp.getCssValue("color");
        String[] homeGrey = colorhrp.split("[^0-9]");
        Assert.assertTrue(homeGrey[0].equals(homeGrey[1]));
        Assert.assertTrue(homeGrey[1].equals(homeGrey[2]));

        String decorhrp = hrp.getCssValue("text-decoration");
        String delimeter = " ";
        String[] homeThrough = decorhrp.split(delimeter);
        Assert.assertEquals("line-through", homeThrough[0]);

        String colorhdr = hdp.getCssValue("color");
        //System.out.println(colorhdr);
        String[] homeRed = colorhdr.split("[^0-9]");
        //for(String n : homeRed) {System.out.println(n);}
        Assert.assertTrue(homeRed[6].equals("0"));
        Assert.assertEquals("0", homeRed[8]);

        Integer weighthdp = Integer.parseInt(hdp.getCssValue("font-weight"));
        Assert.assertTrue(weighthdp > 700);

        String sizeHr = hrp.getCssValue("font-size");
        String[] hrpSize = sizeHr.split("[^0-9]");
        Integer sHr = Integer.parseInt(hrpSize[0]);
        String sizeHd = hdp.getCssValue("font-size");
        String[] hdpSize = sizeHd.split("[^0-9]");
        Integer sHd = Integer.parseInt(hdpSize[0]);
        Assert.assertTrue(sHr < sHd);



        wd.findElement(By.cssSelector("div#box-campaigns a.link")).click();
        String pageName = wd.findElement(By.cssSelector("div#box-product h1")).getAttribute("innerText");
        String pageRegular = wd.findElement(By.cssSelector("div#box-product s.regular-price")).getAttribute("innerText");
        String pageDiscount = wd.findElement(By.cssSelector("div#box-product strong.campaign-price")).getAttribute("innerText");
        WebElement prp = wd.findElement(By.cssSelector("div#box-product s.regular-price"));
        WebElement pdp = wd.findElement(By.cssSelector("div#box-product strong.campaign-price"));
        String colorprp = prp.getCssValue("color");
        String[] pageGrey = colorprp.split("[^0-9]");
        Assert.assertTrue(pageGrey[0].equals(pageGrey[1]));
        Assert.assertTrue(pageGrey[1].equals(pageGrey[2]));

        String decorprp = prp.getCssValue("text-decoration");
        String[] pageThrough = decorprp.split(delimeter);
        Assert.assertEquals("line-through", pageThrough[0]);

        String colorpdp = pdp.getCssValue("color");
        String[] pageRed = colorpdp.split("[^0-9]");
        Assert.assertTrue(pageRed[6].equals("0"));
        Assert.assertEquals("0", pageRed[8]);

        Integer weightpdp = Integer.parseInt(pdp.getCssValue("font-weight"));
        Assert.assertTrue(weightpdp >= 700);
        //System.out.println(weightpdp);

        String sizePr = prp.getCssValue("font-size");
        String[] prpSize = sizePr.split("[^0-9]");
        Integer sPr = Integer.parseInt(prpSize[0]);
        String sizePd = pdp.getCssValue("font-size");
        String[] pdpSize = sizePd.split("[^0-9]");
        Integer sPd = Integer.parseInt(pdpSize[0]);
        Assert.assertTrue(sPr < sPd);

        Assert.assertEquals(homeName, pageName);
        Assert.assertEquals(homeRegular, pageRegular);
        Assert.assertEquals(homeDiscount, pageDiscount);
    }

    @AfterMethod
    public void tearDown() { wd.quit(); }
}
