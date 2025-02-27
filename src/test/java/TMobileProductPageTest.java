import Pages.DevicePage;
import Pages.HomePage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TMobileProductPageTest extends BaseTest {
    @Test
    public void addProductToBasketTest() {
        Map<String, String> priceMap = new HomePage()
                .openPage()
                .goToDevices()
                .selectFirstDevice()
                .getPricesFromPage();
        new DevicePage()
                .addToBasket()
                .checkPrice(priceMap)
                .backToHomePage()
                .verifyNumberOfProducts("1");
    }
}
