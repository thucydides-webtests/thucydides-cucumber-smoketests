package com.bddinaction.flyinghigh.cucumber.steps;

import com.bddinaction.flyinghigh.cucumber.flowsteps.TravellerFlowSteps;
import com.bddinaction.flyinghigh.cucumber.pages.BookingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

public class BookingAFlightSteps {

    @Steps
    TravellerFlowSteps traveller;

    @Given("^I want to book a flight$")
    public void givenIWantToBookAFlight() {
        traveller.navigateToFlightBookings();
    }

    @Given("^the following flight timetable:$")
    public void givenTimetable(DataTable timetable) {
        for( DataTableRow row : timetable.getGherkinRows()) {
            Map<String, Object> stringObjectMap = row.toMap();
            String number = (String)stringObjectMap.get("number");
            String departure = (String)stringObjectMap.get("departure");
            String destination = (String)stringObjectMap.get("destination");
            String time = (String)stringObjectMap.get("time");
        }
    }

    @Then("^I should see the following flights:$")
    public void shouldSeeFlights(DataTable expectedFlights) {
        for( DataTableRow row : expectedFlights.getGherkinRows()) {
            Map<String, Object> stringObjectMap = row.toMap();
            String number = (String)stringObjectMap.get("number");
            String departure = (String)stringObjectMap.get("departure");
            String destination = (String)stringObjectMap.get("destination");
            String time = (String)stringObjectMap.get("time");
        }
    }

    @When("^I search for (.+) flights from (.+) to (.+) in (.+)$")
    public void whenISearchForFlights(String flightType, String from,
                                      String to, String travelClass) {

        traveller.searchForFlights(flightType, from, to, travelClass);
    }

    @Then("^I should see the list of all available flights$")
    public void thenIShouldSeeTheListOfAllAvailableFlights() {
    }

    BookingPage bookingPage;

    @When("I enter (.+) into the 'from' city field")
    public void enterFromPrefix(String prefix) {
        System.out.println("Booking page set from " + prefix);
        bookingPage.setFrom(prefix);
    }

    @Then("I should see the following cities: (.+)")
    public void shouldSeeCities(List<String> expectedCities) {
        System.out.println("Booking page " + expectedCities + " XX " + bookingPage.getFrom() + " " + bookingPage.hashCode()  + " in step " + this + "  " + this.hashCode());
        System.out.println("Get from typeaheads  1 " + bookingPage.getTypeaheadEntries());
        System.out.println("Get from typeaheads  " + bookingPage.getFromTypeaheads());
        assertThat(bookingPage.getFromTypeaheads()).containsAll(expectedCities)
                                                   .hasSize(expectedCities.size());

    }

}
