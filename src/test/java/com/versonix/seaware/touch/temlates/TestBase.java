package com.versonix.seaware.touch.temlates;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.versonix.seaware.touch.pages.AppManager;

import java.io.IOException;

/**
 * Created by anna on 7/28/18.
 */


public class TestBase {

   public static final AppManager app = new AppManager();

     public  String driverType = System.getProperty("browser");

     @BeforeClass
     public void before() throws IOException {
          app.init(driverType);

          app.startExecuteTests(driverType);

     }



     @AfterClass
     public void afterClass() throws IOException {
       //   writeOutputCsv("./src/test/java/com/resources/outputData");  // "/Users/anna/Desktop/"
       //   app. tearDown()  ;

     }


}
