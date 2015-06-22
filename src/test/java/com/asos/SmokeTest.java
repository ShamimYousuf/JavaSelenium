package com.asos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SmokeTest {

    WebDriver driver;

    @Before
    public void setUp(){
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyPricingRangeFilterTest1(){


        driver.get("http://www.asos.com");

        Actions actions = new Actions(driver);
        WebElement menuHoverLink = driver.findElement(By.cssSelector(".floor_1 "));
        actions.moveToElement(menuHoverLink);

        WebElement subLink = driver.findElement(By.cssSelector(".sub-floor-menu .section ul.items li a"));

        actions.moveToElement(subLink);
        actions.click();
        actions.perform();

        Assert.assertEquals(driver.getTitle(), "New clothing | The latest fashion clothing | ASOS");

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/a"));
        Actions moveSlider = new Actions(driver);
        Action action = (Action) moveSlider.dragAndDropBy(slider, 30, 0).build();
        action.perform();

        Select oSelection = new Select(driver.findElement(By.id("ctl00_ContentMainPage_ctlCategoryRefine_drpdwnPageSort")));
        oSelection.selectByVisibleText("Price high to low");


    }

    @After
    public void tearDown(){
        driver.close();
    }


}
