package Pages;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DevicesPage extends BasePage {
    String firstProductCSS = ".dt_productCards";
    public DevicePage selectFirstDevice() {
        $(firstProductCSS).shouldBe(visible);
        $(firstProductCSS).click();
        return new DevicePage();
    }
}
