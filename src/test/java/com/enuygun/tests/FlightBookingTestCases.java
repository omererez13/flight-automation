package com.enuygun.tests;

import com.enuygun.base.BaseTest;
import com.enuygun.pages.FlightListingPage;
import com.enuygun.pages.FlightSearchPage;
import com.enuygun.pages.PersonelInformationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//Testcaselerin bulunduğu class
public class FlightBookingTestCases extends BaseTest {
    FlightSearchPage flightSearchPage = new FlightSearchPage();
    FlightListingPage flightResultsPage = new FlightListingPage();

    @Test
    public void testCase1() {
        flightSearchPage.addReturnLabel(returnDate);
        flightSearchPage.clickSearchButton();
        flightResultsPage.setSlider(firstValueOfSlider, secondValueOfSlider);
        Assert.assertTrue(flightResultsPage.verifyDepartureTimesBetween(firstValueOfSlider, secondValueOfSlider),
                "Kalkış saatleri "+firstValueOfSlider+":00 ile "+secondValueOfSlider+":00 arasında değil.");
    }

    @Test
    public void testCase2() {
        testCase1();
        Assert.assertTrue(flightResultsPage.checkPricesOfFilteredList(),
                "Türk Hava Yollarına ait doğru fiyatlar sıralanamadı.");
    }

    @Test
    public void testCase3() {
        PersonelInformationPage personelInformationPage = new PersonelInformationPage();
        flightSearchPage.clickSearchButton();
        String timeDatas = flightResultsPage.getfirstFlightTimeData();
        String splitWith = " - ";
        String[] times = timeDatas.split(splitWith);
        String departureTime = times[0];
        String arrivalTime = times[1];
        flightResultsPage.firstFlightSelection();

        boolean condition1 = personelInformationPage.checkDepartureTime(departureTime);
        boolean condition2 = personelInformationPage.checkArrivalTime(arrivalTime);
        boolean condition3 = personelInformationPage.checkDepartureAirportName(departureCityName);
        boolean condition4 = personelInformationPage.checkArrivalAirportName(arrivalCityName);

        Assert.assertTrue(condition1 && condition2 && condition3 && condition4, "Seçilen bilgiler ve gösterilenler birbirine eşeleşmiyor.");
    }
}
