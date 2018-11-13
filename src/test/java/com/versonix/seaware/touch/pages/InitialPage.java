package com.versonix.seaware.touch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.versonix.seaware.touch.temlates.HelperDriverBase;

/**
 * Created by anna on 7/28/18.
 */
public class InitialPage extends HelperDriverBase {


     InitialPage(WebDriver driver) {
          //  this.driver = wd;
          super(driver);
     }




//     final By sideMenuItem   = By.cssSelector("a#gwt-uid-384");
//     // Login Button
//     final By login_button = By.xpath("//a[@id=\"gwt-uid-220\"]");
//     // Res Agent Tab on login wizard
//     final By resAgent_tab = By.xpath("//a[@id=\"gwt-uid-401\"]");
//     //  Input UserName text
//     final By username_input = By.xpath("//input[@id=\"gwt-uid-386\"]");
//     // Input  Password text
//     final By passw_input = By.xpath("//input[@id=\"gwt-uid-388\"]");
//     // Login Submit button
//     final By loginSubmit_button = By.xpath("//a[@id=\"gwt-uid-392\"]");


     final By sideMenuItem   = By.cssSelector("#gwt-uid-384");  //
     // Login Button
     final By login_button = By.xpath("//a[@id=\"gwt-uid-219\"]");
     // Res Agent Tab on login wizard
     final By resAgent_tab = By.xpath("//a[@id=\"gwt-uid-398\"]");
     //  Input UserName text
     final By username_input = By.xpath("//input[@id=\"gwt-uid-383\"]");
     // Input  Password text
     final By passw_input = By.xpath("//input[@id=\"gwt-uid-385\"]");
     // Login Submit button
     final By loginSubmit_button = By.xpath("//a[@id=\"gwt-uid-389\"]");


     public  String firstSideMenuItem (){

          return getTextOfElement(sideMenuItem);
     }


     public  void loginAs_ResAgent (String login, String password){
          clickLogin_button ();
          clickResAgent_tab();
          typeUsername(login);
          typePassword(password);
          clickSubmit_button();
     }





     public void clickLogin_button (){
          clickElementclickable(login_button);
     }

     public void clickResAgent_tab (){
          clickElementclickable(resAgent_tab);
     }

     public void typeUsername (String user){

          setText(username_input, user);
     }


     public void typePassword (String pass){
          setText(passw_input, pass);
     }


     public void clickSubmit_button(){
          clickElementclickable(loginSubmit_button);
     }

}
