import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        open("https://www.t-mobile.pl/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
