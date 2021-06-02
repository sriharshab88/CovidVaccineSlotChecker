package script;

import com.jayway.restassured.response.Response;
import data.TestData;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import platformLayer.ResourceLayer;
import resources.Endpoints;
import resources.Resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SlotChecker extends ResourceLayer {


    static final int value = 10;
    @Test(invocationCount = value)
    public void getCoWinVaccinationSlots() throws InterruptedException {

        String testEndpoint = Resources.coWinHost + Endpoints.endpoint + "?district_id=" + TestData.districtId + "&date=" + TestData.datePicker();

        Response response = getResponse(testEndpoint);
        Assert.assertEquals(response.statusCode(), 200, "Status code is not matching");

        JSONObject availableSlots = new JSONObject();
        int slotCounter = 0;

        JSONObject centers = new JSONObject(response.asString());
        JSONArray listOfCentres = centers.getJSONArray("centers");

        for (int i = 0; i < listOfCentres.length(); i++) {
            JSONObject eachCentre = listOfCentres.getJSONObject(i);
            JSONArray sessions = eachCentre.getJSONArray("sessions");
            for (int j = 0; j < sessions.length(); j++) {
                if (sessions.getJSONObject(j).getInt("min_age_limit") == 18
                        && sessions.getJSONObject(j).getInt("available_capacity_dose1") > 0) {
                    slotCounter++;
                    JSONArray eachSlot = new JSONArray();
                    eachSlot.put("Date: " + sessions.getJSONObject(j).get("date") + "");
                    eachSlot.put("Vaccine: " + sessions.getJSONObject(j).get("vaccine") + "");
                    eachSlot.put("Age: " + sessions.getJSONObject(j).get("min_age_limit") + "");
                    eachSlot.put("Available dose: " + sessions.getJSONObject(j).get("available_capacity_dose1") + "");
                    eachSlot.put("Center: " + eachCentre.get("name") + "");
                    eachSlot.put("Address: " + eachCentre.get("address") + "");
                    eachSlot.put("District: " + eachCentre.get("district_name") + "");
                    eachSlot.put("Area: " + eachCentre.get("block_name") + "");
                    availableSlots.put("Slot " + slotCounter + "", eachSlot);
                }
            }

        }
        if (slotCounter != 0) {
            System.out.println("Total Available slots: " + availableSlots.length());
            System.out.println("Slot details: " + availableSlots + "");
        } else {
            System.out.println("Slots are Not available currently");
        }

       // Thread.sleep(5000);

    }



}
