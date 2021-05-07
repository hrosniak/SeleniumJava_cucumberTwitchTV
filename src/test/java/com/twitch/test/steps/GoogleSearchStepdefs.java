package com.twitch.test.steps;

import com.twitch.test.pages.GoogleSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepdefs  {

    GoogleSearchPage googlePage = new GoogleSearchPage();

    @Given("Google page is opened")
    public void googlePageIsOpened() {
        googlePage.openGooglePage();
    }

    @When("I close private politics frame")
    public void iClosePrivatePoliticsFrame() {
        googlePage.closePolitics();
    }

    @And("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) {
        googlePage.searchInGoogle(searchPhrase);
    }

    @And("I click for first element on page")
    public void iClickForFirstElementOnPage() {
        googlePage.clickInFirstElementOnWebsite();
    }

    @Then("I accept cookie")
    public void iAcceptCookie() {
        googlePage.acceptCookieFrame();
    }




}
