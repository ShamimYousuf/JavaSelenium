package com.asos;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SmokeTest1 {

    @Test
    public void verifyPricingRangeFilter(){
        WebDriver driver= new FirefoxDriver();

        driver.get("http://www.asos.com");

        Actions actions = new Actions(driver);
        WebElement menuHoverLink = driver.findElement(By.cssSelector(".floor_1 "));
        actions.moveToElement(menuHoverLink);

        WebElement subLink = driver.findElement(By.cssSelector(".sub-floor-menu .section ul.items li a"));

        actions.moveToElement(subLink);

        System.out.print(" linktext is "+ subLink.getTagName());

        actions.click();
        actions.perform();

        System.out.println("Page title is: " + driver.getTitle());

        System.out.print(driver.findElement(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")).getText());

        Select oSelection = new Select(driver.findElement(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")));
        oSelection.selectByVisibleText("Price high to low");

        WebElement slider = driver.findElement(By.cssSelector("a.ui-slider-handle"));
        System.out.println("slider is: " + slider.getText());

        driver.quit();
        driver.close();
    }


}
