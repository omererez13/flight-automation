package com.enuygun.base;

import com.codeborne.selenide.Configuration;
import com.enuygun.pages.FlightSearchPage;
import com.enuygun.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    // Test senaryolarında kullanılan ortak değişkenler
    protected int firstValueOfSlider = 10;
    protected int secondValueOfSlider = 18;
    protected String departureCityName = "İstanbul";
    protected String arrivalCityName = "Ankara";
    protected String departureDate = "2024-11-15";
    protected String returnDate = "2024-11-16";

    @BeforeMethod
    public void setUp() {
        FlightSearchPage flightSearchPage = new FlightSearchPage();
        // Konfigürasyon dosyasını okuyarak ayarları yükle daha sonra bu ayarları kullan
        ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");
        Configuration.browser = configReader.getProperty("browser");
        Configuration.browserSize = configReader.getProperty("browser.size");
        Configuration.timeout = Long.parseLong(configReader.getProperty("timeout"));

        String baseUrl = configReader.getProperty("base.url");
        open(baseUrl);
        // Testcaselerde ortak bazı kodlar tekrara düşmemek için buradan çalıştırıldı
        flightSearchPage.enterDepartureCity(departureCityName);
        flightSearchPage.enterArrivalCity(arrivalCityName);
        flightSearchPage.departOnLabel(departureDate);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
