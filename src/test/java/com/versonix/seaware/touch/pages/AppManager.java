package com.versonix.seaware.touch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anna on 7/28/18.
 */
public class AppManager {

     private static  WebDriver driver ;
// WebDriverWait wait = new WebDriverWait(driver, 30);


     public static WebDriver getWebDriver(){
          return driver;
     }

// Declaration Pages:
     private InitialPage initialPage  ;




     private String startUrl = null;



 // getters of pages classes
     public InitialPage onInitPage (){
          return initialPage;
     }









//     public  boolean titleIS ( ){
//      return    wait.until(ExpectedConditions.titleIs("SeawareTouch - Voyages"));
//     }

public void init (String browser) throws IOException {
     setWebDriver(browser);

     initialPage = new InitialPage(driver);

}



     @Step("Check driver is NOT null")
     public void startExecuteTests ( String driver){
          // openHomePage(prodUrl);


          if (driver == null) {
               System.out.println("BeforeMethod: driver is null!");}

          try {

               openInitialPage();

          } catch (Exception ex) {
               System.out.println(ex.getStackTrace());
          }

     }






     public void openInitialPage(){


          startUrl = "http://harbor.vcs-external.versonix.com:8080/touchvv/vx-voyageSearchInterval";

          initialPage.openPage(startUrl);

          System.out.println("open  Intitial Page()   Ends");

     }






     @Step("Close driver ")
     public void tearDown()  throws IOException {

          // driver.close();
          driver.quit();

     }











     public  void setWebDriver (String browser) {

          Logger logger = Logger.getLogger("");
          logger.setLevel(Level.OFF);
          String driverPath = "" ;

          if ((browser.toLowerCase().equals("firefox")) && (System.getProperty("os.name").toUpperCase().contains("MAC"))) {
               driverPath = "./resources/webdrivers/mac/geckodriver" ;
               System.out.println("identified driver = " + driverPath); } // geckodriver.sh"

          else if ((browser.toLowerCase().equals("firefox") ) && (System.getProperty("os.name").toUpperCase().contains("WINDOWS") ))  {
               driverPath = "./resources/webdrivers/pc/geckodriver.exe" ;}

          else  if (( browser.toLowerCase().equals("firefox"))  &&   (System.getProperty("os.name").toUpperCase().contains("LINUX")))  {
               driverPath = "./resources/webdrivers/lnx/geckodriver.sh";
               System.out.println("identified driver = " + driverPath) ;}




          else if ((browser.toLowerCase().equals("chrome")) && (System.getProperty("os.name").toUpperCase().contains("MAC")))
          {driverPath = "./resources/webdrivers/mac/chromedriver";
               System.out.println("identified driver = " + driverPath);   }

          else if  ((browser.toLowerCase() .equals("chrome")) && (System.getProperty("os.name").toUpperCase().contains("LINUX")) ) {
               driverPath = "./resources/webdrivers/lnx/chromedriver64";

               System.out.println("identified driver = " + driverPath); }

          else if ((browser.toLowerCase().contains("chrome")) && (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))) {

               driverPath = "./resources/webdrivers/pc/chromedriver.exe";}


          else if ((browser.toLowerCase().contains("edge")) && (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))) {

               driverPath = "./resources/webdrivers/pc/MicrosoftWebDriver.exe";}

          else if ( (browser.toLowerCase().contains("safari")) ) { System.out.println("identified driver =  SAFARI" );  }

          else if ( (browser.toLowerCase().contains("html")) ) {  System.out.println("identified driver =  HTMLUnit" );}


          else   {throw new IllegalArgumentException("Unknown OS");}


          switch (browser){
               case "firefox" :

                    System.setProperty("webdriver.gecko.driver", driverPath);
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;

               case "chrome" :

                    System.setProperty("webdriver.chrome.driver", driverPath);
                    //		System.setProperty("webdriver.chrome.silentOutput", "true");

                    ChromeOptions option = new ChromeOptions();
                    //		option.addArguments("disable-infobars");
                    //		option.addArguments("--disable-notifications");

                    if (System.getProperty("os.name").toUpperCase().contains("MAC"))
                         option.addArguments("-start-fullscreen");

                    else if (System.getProperty("os.name").toUpperCase().contains("LINUX"))
                         option.addArguments("-start-fullscreen");

                    else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                         option.addArguments("--start-maximized");
                    else
                         throw new IllegalArgumentException("Unknown OS");

                    driver = new ChromeDriver(option);
                    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    break;


               case "safari":
                    if (!System.getProperty("os.name").contains("Mac")) {
                         throw new IllegalArgumentException("Safari is available only on Mac");
                    }

                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;

               case "edge":


                    if (!System.getProperty("os.name").contains("Windows"))
                         throw new IllegalArgumentException("MS Edge is available only on Windows");

                    System.setProperty("webdriver.edge.driver", driverPath);
                    driver = new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;

               case "html":
                    driver = new HtmlUnitDriver();

                    ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;

               default: throw new IllegalArgumentException("Unknown Browser");

          }

     }







     public void driverStop(){
          driver.quit();
     }

}
