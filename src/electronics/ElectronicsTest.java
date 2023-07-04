package electronics;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']"));
        //define expected
        String expectedText = "Cell phones";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals("//h1[contains(text(),'Cell phones')]", expectedText, actualText);

    }

    @Test
    public void TestNameVerifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']"));
        //define expected
        String expectedText = "Cell phones";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals("//h1[contains(text(),'Cell phones')]", expectedText, actualText);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        //define expected
        //  String expectedText1 = "Nokia Lumia 1020";
        //get actual text
        //    String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')"));
        //2.6 Verify the text “Nokia Lumia 1020”
        //   Assert.assertEquals("//h1[contains(text(),'Nokia Lumia 1020')]", expectedText1, actualText1);
        Thread.sleep(1000);
        //define expected
        String expectedPrice = "$349.00";
        //get actual text
        String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        //2.7 Verify the price “$349.00”
        Assert.assertEquals("//span[contains(text(),'$349.00')]", expectedText, actualText);
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//div[@class='bar-notification success']/p"),"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        Thread.sleep(1000);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //define expected
        String expectedTextShoppingCart = "Shopping cart";
        //get actual
        String actualTextShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);
        Thread.sleep(1000);
        //2.13 Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedText1 = "2";
        String actualText2 = text.getAttribute("value");
        Assert.assertEquals("not equal", expectedText1, actualText2);

        //  define expected
        String expectedTotal = "$698.00";
        //get actual
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        //2.14 Verify the Total $698.00
        Assert.assertEquals("Total Price is different ", expectedTotal, actualTotal);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");

        Thread.sleep(2000);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyText(By.xpath("//button[contains(text(),'Register')]"),"REGISTER");

        Thread.sleep(2000);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Khushi");
        sendTextToElement(By.id("LastName"), "Pandey");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "15");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "April");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1991");
        sendTextToElement(By.xpath("//input[@id='Email']"), "khushi123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "abc");
        clickOnElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElement(By.xpath("//input[@id='Password']"), "Khushi@123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Khushi@123");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(2000);

        //2.22 Verify the message “Your registration completed”
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        Thread.sleep(2000);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //define expected
        String expectedTextShoppingCard = "Shopping cart";
        //get actual
        String actualTextShoppingCard = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.24 Verify the text “Shopping card”
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCard, actualTextShoppingCard);
        Thread.sleep(1000);

    }
}