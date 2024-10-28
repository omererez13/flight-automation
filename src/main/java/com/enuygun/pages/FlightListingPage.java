package com.enuygun.pages;

import com.enuygun.helpers.TestHelper;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FlightListingPage {
    private final TestHelper testHelper = new TestHelper();

    // Kalkış ve iniş saatlerini kontrol eder
    public boolean verifyDepartureTimesBetween(int startHour, int endHour) {
        String validateSliderContentDiv = "(//div[contains(@class, 'filter-slider-content')])[1]";
        return Objects.equals(testHelper.getText(validateSliderContentDiv, 20), startHour+":00 ile "+endHour+":00 arası");
    }

    // Slider ayarlarını günceller
    public void setSlider(int startHour, int endHour) {
        String slider = "//div[@data-testid='departureDepartureTimeSlider']";
        String leftHandleDiv = slider + "//div[contains(@class, 'rc-slider-handle-1')]";
        String rightHandleDiv = slider + "//div[contains(@class, 'rc-slider-handle-2')]";
        String departureReturnTimeCardHeaderDiv = "//div[contains(@class, 'ctx-filter-departure-return-time card-header')]";
        testHelper.clickMe(departureReturnTimeCardHeaderDiv, 20);

        SelenideElement sliderElement = $x(slider).shouldBe(visible, Duration.ofSeconds(20));
        SelenideElement leftHandleElement = $x(leftHandleDiv).shouldBe(visible, Duration.ofSeconds(20));
        SelenideElement rightHandleElement = $x(rightHandleDiv).shouldBe(visible, Duration.ofSeconds(20));

        int totalWidth = sliderElement.getSize().getWidth();
        int hourWidth = totalWidth / 24;
        int leftOffset = startHour * hourWidth;
        leftOffset = (leftOffset*100)/totalWidth;
        int rightOffset = endHour * hourWidth;
        rightOffset = (rightOffset*100)/totalWidth;

        executeJavaScript("arguments[0].style.left='" + leftOffset + "%'", leftHandleElement);
        sleep(500);
        executeJavaScript("arguments[0].style.left='" + rightOffset + "%'", rightHandleElement);
        sleep(500);
        testHelper.clickMe(leftHandleDiv, 20);
        sleep(500);
        testHelper.clickMe(rightHandleDiv, 20);
        sleep(5000);
    }

    // Filtreleme yapar, liste fiyatlarını kontrol eder
    public boolean checkPricesOfFilteredList() {
        String companyCardHeaderDiv = "//div[contains(@class, 'ctx-filter-airline card-header')]";
        testHelper.clickMe(companyCardHeaderDiv, 20);
        String selectCompanyLabel = "//label[contains(@for, 'TKairlines')]";
        testHelper.clickMe(selectCompanyLabel, 20);
        int i = 0;
        while (i<6){
            String listedDynamicCompanyNameDiv = "//div[contains(@id, 'flight-"+i+"')]//div[contains(@data-testid, 'Türk Hava Yolları')]";
            String listedDynamicTicketPriceSpan = "//div[contains(@id, 'flight-"+i+"')]//span[contains(@class, 'money-int')]";

            if (testHelper.getText(listedDynamicCompanyNameDiv, 20).equals("Türk Hava Yolları")){
                String listedDynamicTicketPriceNextSpan = "//div[contains(@id, 'flight-"+(i+1)+"')]//span[contains(@class, 'money-int')]";
                double firstListedDynamicTicketPrice = Double.parseDouble(testHelper.getText(listedDynamicTicketPriceSpan, 20));
                double secondListedDynamicTicketPrice = Double.parseDouble(testHelper.getText(listedDynamicTicketPriceNextSpan, 20));
                if(firstListedDynamicTicketPrice<=secondListedDynamicTicketPrice){
                    i++;
                    System.out.println(firstListedDynamicTicketPrice+" <= "+secondListedDynamicTicketPrice);
                }else return false;
            }
        }
        return i == 6;
    }

    //Daha sonra FlightBookingTestCases da kontroller sağlamak için gerekli datalar alındı ve FlightBookingTestCases a gönderildi
    public String getfirstFlightTimeData(){
        String departureTime = "(//div[@data-testid='departureTime'])[1]";
        String departureTimeOfFirstItem = testHelper.getText(departureTime, 20);
        String arrivalTime = "(//div[@data-testid='arrivalTime'])[1]";
        String arrivalTimeOfFirstItem = testHelper.getText(arrivalTime, 20);
        return departureTimeOfFirstItem+" - "+arrivalTimeOfFirstItem;
    }

    //Sonraki sayfaya erişebilmek için ilk uygun elemente tıklandı
    public void firstFlightSelection() {
        String selectButtonOfFirstItem = "(//button[@class='action-select-btn tr btn btn-success btn-sm'])[1]";
        String selectAndNextButtonOfFirstItem = "//button[@data-testid='providerSelectBtn']";
        testHelper.clickMe(selectButtonOfFirstItem, 20);
        testHelper.clickMe(selectAndNextButtonOfFirstItem, 20);
    }
}
