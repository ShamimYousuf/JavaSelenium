package com.asos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created with IntelliJ IDEA.
 * User: shamimyousuf
 * Date: 19/06/2015
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class SmokeTest1 {

    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
//        WebDriver driver = new HtmlUnitDriver();

        WebDriver driver= new FirefoxDriver();
//        WebDriver driver = new SafariDriver();
//        WebDriver driver =   new ChromeDriver();
        // And now use this to visit Google
        driver.get("http://www.asos.com");


        Actions actions = new Actions(driver);
        WebElement menuHoverLink = driver.findElement(By.cssSelector(".floor_1 "));
        actions.moveToElement(menuHoverLink);

        WebElement subLink = driver.findElement(By.cssSelector(".sub-floor-menu .section ul.items li a"));

        actions.moveToElement(subLink);

        System.out.print(" linktext is "+ subLink.getTagName());




//        actions.clickAndHold();
        actions.click();
        actions.perform();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        System.out.print(driver.findElement(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")).getText());

        Select oSelection = new Select(driver.findElement(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")));
        oSelection.selectByVisibleText("Price high to low");

        WebElement slider = driver.findElement(By.cssSelector("a.ui-slider-handle"));
        System.out.println("slider is: " + slider.getText());


//        actions.moveToElement(slider).clickAndHold();
//        actions.clickAndHold();
//        actions.moveByOffset(45,58)    ;



        driver.quit();

        driver.close();
    }

}
