package com.bddinaction.flyinghigh.cucumber.steps;

import com.bddinaction.flyinghigh.cucumber.flowsteps.AuthenticationFlowSteps;
import com.bddinaction.flyinghigh.cucumber.model.FrequentFlyerMember;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;



public class UserAuthenticationSteps {

    @Steps
    private AuthenticationFlowSteps registeredMember;

    @Given("^(.+) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(FrequentFlyerMember user) {}

    @When("^(.+) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember user) {
        registeredMember.enterEmailAndPasswordFor(user);
    }

    @Then("^(.+) should be given access to her account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember user) {
        registeredMember.verifyWelcomeMessageFor(user);
    }

    @Given("^(.+) has logged on$")
    public void aUserHasLoggedOnAs(FrequentFlyerMember user) {
        registeredMember.enterEmailAndPasswordFor(user);
    }

    @When("^(.+) views the home page$")
    public void whenAUserViewsTheHomePage(String user) {}

}
