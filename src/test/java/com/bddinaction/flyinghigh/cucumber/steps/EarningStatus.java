package com.bddinaction.flyinghigh.cucumber.steps;

import com.bddinaction.flyinghigh.model.FrequentFlyer;
import com.bddinaction.flyinghigh.model.Status;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.fest.assertions.api.Assertions.assertThat;

public class EarningStatus {

    String firstName;
    String lastName;

    @Given("^(.+) (.+) is not a Frequent Flyer member$")
    public void not_a_Frequent_Flyer_member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    FrequentFlyer member;

    @Given("^(.+) (.+)  is a (.+) Frequent Flyer member$")
    public void a_Frequent_Flyer_member(String firstName, String lastName, Status status) {
        member = FrequentFlyer.withFrequentFlyerNumber("12345678")
                              .named(firstName,lastName);
        member.setStatus(status);
    }

    @Given("^a member has a status of (.+)$")
    public void a_Frequent_Flyer_member(Status initialStatus) {
        member = FrequentFlyer.withFrequentFlyerNumber("12345678").named("Joe","Bloggs");
        member.setStatus(initialStatus);
    }

    @When("^he registers on the Frequent Flyer program$")
    public void he_registers_on_the_Frequent_Flyer_program() throws Throwable {
        member = FrequentFlyer.withFrequentFlyerNumber("123456789")
                              .named(firstName, lastName);
    }

    @When("^she registers on the Frequent Flyer program$")
    public void she_registers_on_the_Frequent_Flyer_program() throws Throwable {
        member = FrequentFlyer.withFrequentFlyerNumber("123456789")
                .named(firstName, lastName);
    }

    @Given("^he has (\\d+) status points$")
    public void earned_status_points(int initialStatusPoints) {
        member.setStatusPoints(initialStatusPoints);
    }

    @When("^he earns (\\d+) extra status points$")
    public void earn_extra_status_points(int extraPoints) {
        member.earns(extraPoints).statusPoints();
    }


    @Then("^he should have a status of (.+)$")
    public void he_should_have_status_of(Status finalStatus) {
        assertThat(member.getStatus()).isEqualTo(finalStatus);
    }

    @Then("^she should have a status of (.+)$")
    public void she_should_have_status_of(Status finalStatus) {
        assertThat(member.getStatus()).isEqualTo(finalStatus);
    }
}
