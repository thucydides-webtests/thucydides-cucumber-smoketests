package com.bddinaction.flyinghigh.cucumber;

import cucumber.api.CucumberOptions;
import net.thucydides.cucumber.CucumberWithThucydides;
import org.junit.runner.RunWith;

@RunWith(CucumberWithThucydides.class)
@CucumberOptions(features = {
        "src/test/resources/features/authentication",
        "src/test/resources/features/earning_points",
        "src/test/resources/features/flights",
        "src/test/resources/features/marketing",
        "src/test/resources/features/status",
        "src/test/resources/features/viewing_flights"})
public class AcceptanceTestSuite {}
