package com.versonix.seaware.touch.temlates;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by anna on 7/28/18.
 */
public class HelperDriverBase {


     protected WebDriver driver;
     public WebDriverWait wait;

     public HelperDriverBase(WebDriver wd) {
          // TODO Auto-generated constructor stub
          this.driver = wd;
        wait = new WebDriverWait(this.driver, 60);

     /*
     Load locators from property file to the memory

          try {
               String pathfile = "./src/test/java/com/resources/locators/prodLocators.properties";
               locatorsProperties.load(new FileInputStream(pathfile));
          } catch (IOException e) {
               throw new RuntimeException("Can't load locators resources", e);			}
   */

     }


     public  void clickElementclickable(final By locator) {
          System.out.println("-> " + locator.toString());
          (highlight(wait.until(ExpectedConditions.elementToBeClickable(locator)))).click();
          //findElement(locator).click();
     }

     protected    WebElement findElementVisible(final By locator) {
          System.out.println("-> " + locator.toString());
          // return highlight(wait.until(ExpectedConditions.elementToBeClickable(locator)));
          return highlight(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
     }




     @Step("Send text[{1}] to fild: [{0}]")
     protected void setText(By locator, String text) {
          findElementVisible(locator).clear();
          findElementVisible(locator).sendKeys(text);
     }



     @Step("Get text from element [{0}]")
     protected String  getTextOfElement(final By locator){
          return   findElementVisible(locator).getText();

     }










     @Step("Open URI [{0}]")
     public void openPage(final String url) {
          driver.get(url.toString());
     }



     @Step("Wait of title [{0}]")

     public String getWAItePageTitle (final String expectedTitle) {
          // wait.until(ExpectedConditions.titleContains(expectedTitle));
          wait.until(ExpectedConditions.titleIs(expectedTitle));

          System.out.println("get title from page " + driver.getCurrentUrl());
          return driver.getTitle();
     }

     public String getPageTitle(){
          //      titleIS();

          String title = driver.getTitle();
          return  title;
     }


     /* Highlight elements on the page */
     public WebElement highlight (final WebElement element) {
          //final String originalBackgroundColor  = element.getCssValue("backgroundColor");
          final JavascriptExecutor elementTestJS = ((JavascriptExecutor) driver); // java script
          elementTestJS.executeScript("arguments[0].style.backgroundColor = 'rgb(0,200,0)'",  element);

          return element;
     }





}
