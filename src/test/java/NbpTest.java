import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static io.restassured.RestAssured.given;

public class NbpTest {
    @Test
    public void currencyTest() {
        Response response = given()
            .when()
                .get("exchangerates/tables/A");
        response.then()
                .statusCode(200);

        ArrayList<LinkedHashMap<String, Objects>> listMap = response.jsonPath().get("rates[0]");
        List<LinkedHashMap<String, Objects>> pkt1 = ListFilter.filterCode(listMap, "USD");
        List<LinkedHashMap<String, Objects>> pkt2 = ListFilter.filterCurrency(listMap, "dolar amerykański");
        List<LinkedHashMap<String,Objects>> pkt3 = ListFilter.filterValueGreaterThan(listMap, 5F);
        List<LinkedHashMap<String,Objects>> pkt4 = ListFilter.filterValueLessThan(listMap, 3F);

        System.out.println("Wyświetl kurs dla waluty o kodzie: USD\n" + pkt1);
        System.out.println("Wyświetl kurs dla waluty o nazwie: dolar amerykański\n" + pkt2);
        System.out.println("Wyświetl waluty o kursie powyżej: 5\n" + pkt3);
        System.out.println("Wyświetl waluty o kursie poniżej: 3\n" + pkt4);
    }
    @Before
    public void setURL() {
        RestAssured.baseURI = "http://api.nbp.pl/api/";
    }
}
