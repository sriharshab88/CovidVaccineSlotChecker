package data;

import vaccineSlotChecker.CovidVaccineSlotChecker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestData {

    public static String districtId = "266";

    public static String datePicker(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void messageDisplay(int count) throws InterruptedException {
        int i = 0;
        while (i <= count){
            CovidVaccineSlotChecker.lblSlotsAreAvailable.setText("Slots are available !!!!");
            Thread.sleep(1000);
            CovidVaccineSlotChecker.lblSlotsAreAvailable.setText("");
            i++;
        }
    }
}
