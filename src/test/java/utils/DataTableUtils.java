package utils;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataTableUtils {

    public static Map<String, String> getDataFromTable(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        return data.get(0);
    }
}
