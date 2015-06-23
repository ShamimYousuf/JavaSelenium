package com.asos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    WebDriver driver;
    @FindBy(css = ".floor_1 ")
    WebElement womenFloor;

    public HomePage(WebDriver driver){
         this.driver = driver;
    }

    public HomePage navigateTo(String url){
        driver.get(url);
        return new HomePage(driver);
    }

    public CategoryPage navigateToWomenCategory(int col, int row){
        Actions actions = new Actions(driver);
        WebElement menuHoverLink = driver.findElement(By.cssSelector(".floor_1 "));
        actions.moveToElement(menuHoverLink);

        WebElement subLink = driver.findElement(By.cssSelector(".sub-floor-menu .section ul.items:nth-child("+col+") li:nth-child("+row+") a"));
        actions.moveToElement(subLink);
        actions.click();
        actions.perform();

        return new CategoryPage(driver);
    }



}
