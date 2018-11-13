package com.versonix.seaware.touch.tests;

import org.testng.annotations.Test;
import com.versonix.seaware.touch.temlates.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by anna on 7/28/18.
 *
 */




public class touchvvTests   extends TestBase {







     @Test
     public void testEncription() throws InterruptedException {


          String expectedIntialTitle ="SeawareTouch - Voyages";
          String  userName = "VX_ANNAP";
          String passw = "NAV";
          System.out.println("  ==>  Running  FIRST Test METHOD");


          Thread.sleep(3000);
          String pageTITLE = app.onInitPage().getPageTitle();
          System.out.println(" #1 pageTITLE = [" + pageTITLE + "]");

          String realTitle = app.onInitPage().getWAItePageTitle(expectedIntialTitle);
          System.out.println(" #2 realTitle = [" + realTitle + "]");

assertThat(realTitle, is(expectedIntialTitle));

          System.out.println(" #2 First Item on Side Menu = [" + app.onInitPage().firstSideMenuItem() + "]");

        //  driverStop();

//          app.onInitPage().loginAs_ResAgent(userName, passw);
//          String newTitle = app.onInitPage().getWAItePageTitle("SeawareTouch - Reservations");
//          System.out.println(" #2 new Title = [" + newTitle + "]");
//
//          assertThat(newTitle, is("SeawareTouch - Reservations"));

     }



     // mvn clean site -Dbrowser=chrome
     // mvn clean test -Dbrowser=chrome

}
