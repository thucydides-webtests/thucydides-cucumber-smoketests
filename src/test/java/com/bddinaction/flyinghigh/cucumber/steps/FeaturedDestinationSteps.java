package com.bddinaction.flyinghigh.cucumber.steps;

import com.bddinaction.flyinghigh.cucumber.model.DestinationDeal;
import com.bddinaction.flyinghigh.cucumber.pages.HomePage;
import cucumber.api.java.en.Then;


import static org.fest.assertions.api.Assertions.assertThat;

/**
 * A description goes here.
 * User: john
 * Date: 6/10/13
 * Time: 9:13 PM
 */
public class FeaturedDestinationSteps {

    HomePage homePage;

    @Then("^she should see (\\d+) featured destinations$")
    public void shouldSeeFeaturedDestinations(int featuredCount) {
        assertThat(homePage.getFeaturedDestinations().size()).isEqualTo(featuredCount);
    }

    @Then("^the featured destinations should include (.+) costing (\\d+)$")
    public void featuredDestinationsShouldInclude(String expectedDestination, int price) {
        DestinationDeal expectedDeal = new DestinationDeal(expectedDestination, price);
        assertThat(homePage.getFeaturedDestinations()).contains(expectedDeal);
    }
}
