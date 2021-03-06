package com.asos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPriceTextOfFirstElement(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".price")));
        return driver.findElement(By.cssSelector(".price")).getText();
    }

    public void reduceMinimumPriceRange(int pos){
        WebElement slider = driver.findElement(By.cssSelector("#slider a"));

        Actions moveSlider = new Actions(driver);
        Action action = (Action) moveSlider.dragAndDropBy(slider, pos, 0).build();
        action.perform();
    }

    public void reduceMaximumPriceRange(int pos){
        WebElement slider = driver.findElement(By.cssSelector("#slider a + a"));

        Actions moveSlider = new Actions(driver);
        Action action = (Action) moveSlider.dragAndDropBy(slider, pos, 0).build();
        action.perform();
    }

    public String getMinimumPriceRange() {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("userMin")));
        return driver.findElement(By.id("userMin")).getText();
    }

    public String getMaximumPriceRange() {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("userMax")));
        return driver.findElement(By.id("userMax")).getText();
    }

    public void sortBy(String sortText) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")));
        Select oSelection = new Select(driver.findElement(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")));
        oSelection.selectByVisibleText(sortText);
    }
}
