package com.asos;

import com.asos.pages.CategoryPage;
import com.asos.pages.HomePage;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SmokeTest {

    public static WebDriver driver;
    CategoryPage categoryPage;

    @BeforeClass
    public static void setUp() throws IOException {
        driver= new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Before
    public void testSetUp() throws IOException {
        driver.manage().deleteAllCookies();
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.navigateToWomenCategory(2,1);
        categoryPage = new CategoryPage(driver);
    }

    @Test
    public void pricingTextIsPresent()  {
        Assert.assertEquals("Price is expected", "£15.00", categoryPage.getPriceTextOfFirstElement().toString());
    }

    @Test
    public void canReduceTheMinimumPriceRangeInPriceFilter()  {
        String originalMinPriceLimit = categoryPage.getMaximumPriceRange();
        categoryPage.reduceMinimumPriceRange(30);
        Assert.assertNotSame("Minimum price range is not equal to 0", originalMinPriceLimit, categoryPage.getMinimumPriceRange());
    }

    @Test
    public void canReduceTheMaximumPriceRangeInPriceFilter() {
        String originalMaxPriceLimit = categoryPage.getMaximumPriceRange();
        categoryPage.reduceMaximumPriceRange(-90);
        Assert.assertNotSame("Minimum price range is not equal to original max",originalMaxPriceLimit,categoryPage.getMaximumPriceRange());
    }

    @Test
    public void sortingIsPresent() {
        categoryPage.sortBy("Price high to low");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
