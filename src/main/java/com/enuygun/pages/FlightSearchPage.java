package com.enuygun.pages;

import com.enuygun.helpers.TestHelper;

public class FlightSearchPage {
    private final TestHelper testHelper = new TestHelper();

    //Nereden uçmak istendiği bilgisini girer
    public void enterDepartureCity(String city) {
        String departureCityLabel = "//label[@data-testid='flight-origin-input-comp']";
        String originItemLi = "//li[@data-testid='endesign-flight-origin-autosuggestion-option-item-0']";
        testHelper.typeMe(departureCityLabel,city,100);
        testHelper.clickMe(originItemLi, 20);
    }

    //Nereye uçmak istendiği bilgisini girer
    public void enterArrivalCity(String city) {
        String arrivalCityLabel = "//label[@data-testid='flight-destination-input-comp']";
        String destinationItemLi = "//li[@data-testid='endesign-flight-destination-autosuggestion-option-item-0']";
        testHelper.typeMe(arrivalCityLabel,city,100);
        testHelper.clickMe(destinationItemLi, 20);
    }
    //Gidiş tarihini girer
    public void departOnLabel(String date) {
        String departOnLabel = "//label[@data-testid='enuygun-homepage-flight-departureDate-input-comp']";
        String datepickerDayLocator = String.format("//button[@title='%s']", date);
        testHelper.clickMe(departOnLabel, 20);
        testHelper.clickMe(datepickerDayLocator, 20);
    }

    //Dönüş tarihini girer
    public void addReturnLabel(String date) {
        String addReturnLabel = "//label[@data-testid='enuygun-homepage-flight-returnDate-input-comp']";
        String datepickerDayLocator = String.format("//button[@title='%s']", date);
        testHelper.clickMe(addReturnLabel, 20);
        testHelper.clickMe(datepickerDayLocator, 20);
    }

    //Arama butonuna tıklar
    public void clickSearchButton() {
        String searchButton = "//button[@data-testid='enuygun-homepage-flight-submitButton']";
        testHelper.clickMe(searchButton, 20);
    }
}
