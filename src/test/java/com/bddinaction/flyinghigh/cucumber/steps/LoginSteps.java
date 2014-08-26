package com.bddinaction.flyinghigh.cucumber.steps;


import com.bddinaction.flyinghigh.cucumber.flowsteps.TravellerFlowSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;


public class LoginSteps {

    @Steps
    TravellerFlowSteps traveller;

    @Given("^(.+) has registered online with a password of (.+)$")
    public void registered_online_with_a_password_of_secret(String username, String password) throws Throwable {
    }

    @When("^(.+) logs on with password (.+)$")
    public void Joe_logs_on_with_password_secret(String username, String password) {
    }

    @Then("he should be given access to the site")
    public void he_should_be_given_access_to_the_site() {
    }

    @Then("he should be informed that his password was incorrect")
    public void he_should_be_informed_that_his_password_was_incorrect() {
        traveller.shouldSeeErrorMessage("expected message");

    }

    @Given("the account has expired")
    public void the_account_has_expired() throws Throwable {
        throw new IOException("Database crashed");
    }

    @Then("he should be informed that his account has expired")
    public void he_should_be_informed_that_his_account_has_expired() {
    }

    @Then("he should be invited to renew his account")
    public void he_should_be_invited_to_renew_his_account() {
    }


}
