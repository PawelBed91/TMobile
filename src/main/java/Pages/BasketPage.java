package Pages;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends BasePage {
    String startPriceCSS = ".accordionHeader .main-amount";
    String monthlyPriceCSS = ".summaryMonthly .main-amount";
    String logoPageCSS = ".logo-panel";

    public BasketPage checkPrice(Map<String, String> map) {
        String startPrice = $(startPriceCSS).getText();
        String monthlyPrice = $(monthlyPriceCSS).getText();

        if (startPrice.equals(map.get("startPrice")) && monthlyPrice.equals(map.get("monthlyPrice"))) {
            logger.info("Ceny na stronie i w koszyku są takie same");
        } else {
            logger.severe("Ceny na stronie i w koszyku są różne");
        }
        return this;
    }

    public HomePage backToHomePage(){
        $(logoPageCSS).click();
        return new HomePage();
    }
}
