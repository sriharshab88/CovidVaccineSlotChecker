package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestData {

    public static String datePicker(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
