package Pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    String disagreeCookiesButtonCSS = "#didomi-notice-disagree-button";
    String topMenuCSS = ".group\\/StickyHeader";
    String devicesXpath = "//button[text()='Urządzenia']/..";
    String smartwatchesXpath = "//a[contains(@data-ga-struct,'Bez abonamentu/Smartwatche')]";
    String basketIconXpath = "//span[text()='Przejdź do strony koszyka']/following-sibling::div";

    public HomePage openPage(){
        $(disagreeCookiesButtonCSS).click();
        $(topMenuCSS).shouldBe(visible);
        return this;
    }

    public DevicesPage goToDevices() {
        $x(devicesXpath).click();
        $x(smartwatchesXpath).shouldBe(visible);
        $x(smartwatchesXpath).click();

        return new DevicesPage();
    }

    public HomePage verifyNumberOfProducts(String number) {
        $x(basketIconXpath).shouldHave(text(number));
        return this;
    }
}
