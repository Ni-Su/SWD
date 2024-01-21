  package ru.stqa.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

  public class ApplicationManager {
      WebDriver wd;
      private final Browser browser;

      public ApplicationManager (Browser browser) {
          this.browser = browser;
      }

      public void init () {
          if (browser.equals(Browser.FIREFOX)) {
              wd = new FirefoxDriver();
          } else if (browser.equals(Browser.CHROME)) {
              wd = new ChromeDriver();
          } else if (browser.equals(Browser.IE)) {
              wd = new InternetExplorerDriver();
          }
          wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
          //wd.get(properties.getProperty("web.baseUrl"));
          wd.get("http://localhost/litecart");
      }

      public void stop () {
          wd.quit();
      }


  }

