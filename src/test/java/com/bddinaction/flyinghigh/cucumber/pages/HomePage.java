package com.bddinaction.flyinghigh.cucumber.pages;

import com.bddinaction.flyinghigh.cucumber.model.DestinationDeal;
import com.beust.jcommander.internal.Lists;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "welcome-message")
    private WebElementFacade welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public List<DestinationDeal> getFeaturedDestinations() {
        List<DestinationDeal> deals = Lists.newArrayList();
        List<WebElementFacade> featuredDestinations = findAll(".featured .featured-destination");
        for (WebElement destinationEntry : featuredDestinations) {
            deals.add(destinationDealFrom(destinationEntry));
        }
        return deals;
    }

    private DestinationDeal destinationDealFrom(WebElement destinationEntry) {
        String destinationCity = $(destinationEntry).findBy(".destination-title").getText();
        String priceValue = $(destinationEntry).findBy(".destination-price").getText();

        int price = Integer.parseInt(priceValue.substring(1));
        return new DestinationDeal(destinationCity, price);
    }
}
