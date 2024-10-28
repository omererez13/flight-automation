package com.enuygun.pages;

import com.enuygun.helpers.TestHelper;
import java.util.Objects;

//Seçilen ve girilen bilgilerin ödemeye geçmeden önce kontrolü sağlanıyor
public class PersonelInformationPage {

    private final TestHelper testHelper = new TestHelper();

    public boolean checkDepartureTime(String departureTime) {
        String departureFlightTimeSpan = "//span[@data-testid='departureFlightTime']";
        String departureFlightTime = testHelper.getText(departureFlightTimeSpan, 20);
        return Objects.equals(departureFlightTime, departureTime);
    }

    public boolean checkArrivalTime(String arrivalTime) {
        String departureFlightTimeSpan = "//span[@data-testid='arrivalFlightTime']";
        String departureFlightTime = testHelper.getText(departureFlightTimeSpan, 20);
        return Objects.equals(departureFlightTime, arrivalTime);
    }

    public boolean checkDepartureAirportName(String departureCityName) {
        String departureAirportNameDiv = "//div[@data-testid='departureAirportName']";
        String departureAirportName = testHelper.getText(departureAirportNameDiv, 20);
        return departureAirportName.contains(departureCityName);
    }

    public boolean checkArrivalAirportName(String arrivalCityName) {
        String arrivalAirportNameDiv = "//div[@data-testid='arrivalAirportName']";
        String arrivalAirportName = testHelper.getText(arrivalAirportNameDiv, 20);
        return arrivalAirportName.contains(arrivalCityName);
    }
}
