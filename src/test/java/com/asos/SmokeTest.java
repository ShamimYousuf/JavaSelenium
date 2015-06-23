package com.asos;

import com.asos.pages.CategoryPage;
import com.asos.pages.HomePage;
import org.junit.*;
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
    public void pricingTextIsPresent(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo("http://www.asos.com");
        homePage.navigateToWomenCategory(2,1);

        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertEquals("Price is expected", "£15.00", categoryPage.getPriceTextOfFirstElement().toString());
    }

    @Test
    public void canReduceTheMinimumPriceRangeInPriceFilter(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo("http://www.asos.com");
        homePage.navigateToWomenCategory(2,1);

        CategoryPage categoryPage = new CategoryPage(driver);
        String originalMinPriceLimit = categoryPage.getMaximumPriceRange();
        categoryPage.reduceMinimumPriceRange(30);
        Assert.assertNotEquals("Minimum price range is not equal to 0",originalMinPriceLimit,categoryPage.getMinimumPriceRange());
    }

    @Test
    public void canReduceTheMaximumPriceRangeInPriceFilter(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo("http://www.asos.com");
        homePage.navigateToWomenCategory(2,1);

        CategoryPage categoryPage = new CategoryPage(driver);
        String originalMaxPriceLimit = categoryPage.getMaximumPriceRange();
        categoryPage.reduceMaximumPriceRange(-90);
        Assert.assertNotEquals("Minimum price range is not equal to original max",originalMaxPriceLimit,categoryPage.getMaximumPriceRange());
    }

    @Test
    public void sortingIsPresent(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo("http://www.asos.com");
        homePage.navigateToWomenCategory(2,1);

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.sortBy("Price high to low");
    }

    @After
    public void tearDown(){
        driver.close();
    }


}
