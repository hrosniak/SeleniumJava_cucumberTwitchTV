package com.twitch.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends BasePage{

    private static final String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "zV9nZe")
    WebElement agreeButton;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;

    @FindBy(how = How.CSS, using = "#rso > div:nth-child(1) > div > div > div > div > div > div.yuRUbf > a > h3")
    WebElement firstResult;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button")
    WebElement cookieAccept;


    public void openGooglePage(){
        driver.get(GOOGLE_URL);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(searchField));
    }

    public void closePolitics(){
        driver.findElement(By.id("zV9nZe"));
        agreeButton.click();
    }

    public void searchInGoogle(String searchPhrase){
        searchField.sendKeys(searchPhrase);
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickInFirstElementOnWebsite(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(firstResult));
        firstResult.click();
    }

    public void acceptCookieFrame(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cookieAccept));
                cookieAccept.click();
    }
}
