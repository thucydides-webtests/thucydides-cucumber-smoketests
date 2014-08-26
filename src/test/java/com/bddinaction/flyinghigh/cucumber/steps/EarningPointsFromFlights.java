package com.bddinaction.flyinghigh.cucumber.steps;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

public class EarningPointsFromFlights {

    @Given("^the flying distance between (.+) and (.+) is (.+) km$")
    public void define_flying_distance(String departure,
                                       String destination,
                                       int distance) {
    }

    @When("^I fly from (.+) to (.+) on (.+)$")
    public void I_fly_from(String departure, String destination, Date date) throws Throwable {
    }

    @Then("^I should earn (\\d+) points$")
    public void I_should_earn_points(int points) throws Throwable {
        Assert.assertThat(points, is(points));
    }

    @Then("^I should earn a status bonus of (\\d+)$")
    public void I_should_earn_a_status_bonus_of(int bonus) throws Throwable {
    }


    @When("^I fly on a flight that is worth (\\d+) base points$")
    public void I_fly_on_a_flight_that_is_worth_base_points(int points) throws Throwable {
    }

    @Then("^I should have guaranteed minimum earned points per trip of (\\d+)$")
    public void I_should_have_guaranteed_minimum_earned_points_per_trip_of(int minimum) throws Throwable {
    }

    @Then("^I should earn (\\d+) points in all")
    public void I_should_earn_points_in_all(int total) throws Throwable {
    }

    @Given("we can earn points with partners")
    public void partnerFeatureAvailable() {
//  TODO: Doesn't work properly yet
//        Assume.assumeTrue("The partner features is ready", false);
    }

}
