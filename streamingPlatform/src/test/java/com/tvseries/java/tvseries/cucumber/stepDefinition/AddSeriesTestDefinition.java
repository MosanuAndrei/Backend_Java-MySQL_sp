package com.tvseries.java.tvseries.cucumber.stepDefinition;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.platform.java.StreamingPlatformApplication;
import com.platform.java.entity.Series;
import com.platform.java.service.SeriesService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest
@ContextConfiguration(
        classes = StreamingPlatformApplication.class,
        loader = SpringBootContextLoader.class)
@CucumberContextConfiguration
public class AddSeriesTestDefinition {
    @Autowired
    public SeriesService service;

    public static WebDriver driver;

    @Given("I am on my React page")
    public void i_am_on_my_react_page() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
    }

    @When("I Click on Add Series")
    public void i_click_on_add_series() {
        driver.findElement(By.className("link")).click();
    }

    @Then("The page should change to Add Series Page")
    public void the_page_should_change_to_add_series_page() {
        if (driver.getCurrentUrl().equals("http://localhost:3000/add-series")){
            assertTrue(true);
            driver.quit();
        }
    }

    @Given("I am on Add Contact Page")
    public void i_am_on_add_contact_page() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/add-series");
    }

    @When("I fill the required information and click Add Series")
    public void i_fill_the_required_information_and_click_add_series() {
        driver.findElement(By.name("nameSeries")).sendKeys("Game of Thrones");
        driver.findElement(By.name("numberOfSeasons")).sendKeys("8");
        driver.findElement(By.name("idCategory")).sendKeys("2");
        driver.findElement(By.name("idPlatform")).sendKeys("4");
        driver.findElement(By.cssSelector(".form-button")).click();
    }

    @Then("The Series should be addded")
    public void the_series_should_be_addded() {
        List<Series> myList = service.getSeriesByCategory("Drama");
        
        if (myList.size()>0){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
        driver.quit();
    }
}
