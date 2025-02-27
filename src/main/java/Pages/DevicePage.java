package Pages;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class DevicePage extends BasePage {
    String startPriceXpath = "//div[contains(@class,'StyledStickySideBar')]//div[text()='Do zapłaty na start']/../..//div[@class='dt_price_change']/div";
    String monthlyPriceXpath = "//div[contains(@class,'StyledStickySideBar')]//div[text()='Do zapłaty miesięcznie']/../..//div[@class='dt_price_change']/div";
    String addToBasketCSS = "[class*='StyledStickySideBar'] button[data-qa='PRD_AddToBasket']";
    public Map<String, String> getPricesFromPage() {
        Map<String, String> map = new HashMap<>();
        map.put("startPrice", $x(startPriceXpath).getText());
        map.put("monthlyPrice", $x(monthlyPriceXpath).getText());
        return map;
    }

    public BasketPage addToBasket(){
        $(addToBasketCSS).click();
        return new BasketPage();
    }

}
