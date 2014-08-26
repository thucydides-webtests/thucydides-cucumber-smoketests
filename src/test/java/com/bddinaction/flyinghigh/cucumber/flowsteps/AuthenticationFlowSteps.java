package com.bddinaction.flyinghigh.cucumber.flowsteps;

import com.bddinaction.flyinghigh.cucumber.model.FrequentFlyerMember;
import com.bddinaction.flyinghigh.cucumber.pages.HomePage;
import com.bddinaction.flyinghigh.cucumber.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AuthenticationFlowSteps {

    protected LoginPage loginPage;
    protected HomePage homePage;

    @Step
    public void enterEmailAndPasswordFor(FrequentFlyerMember user) {
        loginPage.open();
        loginPage.signinAs(user.getEmail(), user.getPassword());
    }

    @Step
    public void verifyWelcomeMessageFor(FrequentFlyerMember user) {
        String welcomeMessage = homePage.getWelcomeMessage();
        assertThat(welcomeMessage, is(equalTo("Welcome " + user.getFirstName())));
    }

    @Step
    public void shouldSeeErrorMessage(String expectedMessage) {
        assertThat("wrong message", is(equalTo(expectedMessage)));
    }
}
