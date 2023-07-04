package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;


public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {

        openBrowser(baseUrl);
    }


    //  1.1 create method with name "selectMenu" it has one parameter name "menu" of type string

    public void selectMenu(String menu) {
        //   1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.linkText(menu));
    }

    //  1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.

    @Test
    public void verifyPageNavigation()
    {
        selectMenu("Electronics");

    }
}

