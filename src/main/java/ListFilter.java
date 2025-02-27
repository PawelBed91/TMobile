import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class ListFilter {
    public static List<LinkedHashMap<String, Objects>> filterCode(ArrayList<LinkedHashMap<String, Objects>> listMap, String currencyCode){
        return listMap.stream().filter(r -> String.valueOf(r.get("code")).equals(currencyCode)).toList();
    }
    public static List<LinkedHashMap<String, Objects>> filterCurrency(ArrayList<LinkedHashMap<String, Objects>> listMap, String currencyName){
        return listMap.stream().filter(r -> String.valueOf(r.get("currency")).equals(currencyName)).toList();
    }
    public static List<LinkedHashMap<String, Objects>> filterValueGreaterThan(ArrayList<LinkedHashMap<String, Objects>> listMap, Float value){
        return listMap.stream().filter(r -> Float.parseFloat(String.valueOf(r.get("mid"))) > value).toList();
    }
    public static List<LinkedHashMap<String, Objects>> filterValueLessThan(ArrayList<LinkedHashMap<String, Objects>> listMap, Float value){
        return listMap.stream().filter(r -> Float.parseFloat(String.valueOf(r.get("mid"))) < value).toList();
    }
}
