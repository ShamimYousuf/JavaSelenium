package com.asos.pages;

import com.asos.util.ReadProperties;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
         this.driver = driver;
    }

    public HomePage navigateToHomePage() throws IOException {
        ReadProperties readProperties = new ReadProperties();
        String url = readProperties.getTestUrl();
        driver.get(url);
//        (new WebDriverWait(driver, 10)).until(ExpectedConditions.urlContains("asos"));
        return new HomePage(driver);
    }

    public CategoryPage navigateToWomenCategory(int col, int row){

        Actions actions = new Actions(driver);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".floor_1 ")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".floor_1 ")).isDisplayed());

        WebElement menuHoverLink = driver.findElement(By.cssSelector(".floor_1 "));

        Assert.assertTrue(menuHoverLink.isDisplayed());
        actions.moveToElement(menuHoverLink);

        WebElement subLink = driver.findElement(By.cssSelector(".sub-floor-menu .section ul.items:nth-child("+col+") li:nth-child("+row+") a"));
        actions.moveToElement(subLink);
        actions.click();
        actions.perform();

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("refine-control-header")));

        Assert.assertTrue(driver.getCurrentUrl().contains("category"));

        return new CategoryPage(driver);
    }



}
