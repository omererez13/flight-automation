package com.enuygun.helpers;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

//Burada tekrara düşmemek için ortak metodlar oluşturuldu
public class TestHelper {

    //Elementi tıklamak için kullanılır
    public void clickMe(String locator, int waitTime) {
        System.out.println("Wait for element to be clickable || " + locator + " ||");
        SelenideElement element = $x(locator).shouldBe(visible, Duration.ofSeconds(waitTime)).shouldBe(enabled);
        element.click();
        System.out.println("Clicked at || " + locator + " ||");
    }
    //Elemente veri girmek için kullanılır
    public void typeMe(String locator, String text, int waitTime) {
        System.out.println("Fill in || " + locator + " || with: " + text);
        SelenideElement element = $x(locator).shouldBe(visible, Duration.ofSeconds(waitTime)).shouldBe(enabled);
        SelenideElement input = element.parent().find("input");
        input.clear();
        input.setValue(text);
    }
    //Elementte bulunan text i almak için kullanılır
    public String getText(String locator, int waitTime) {
        System.out.println("Get text of || " + locator + " ||");
        SelenideElement element = $x(locator).shouldBe(visible, Duration.ofSeconds(waitTime)).shouldBe(enabled);
        String text = element.getText();
        System.out.println("Element text is || " + text + " ||");
        return text;
    }
}
