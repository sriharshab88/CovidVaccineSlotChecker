package script;

import com.jayway.restassured.response.Response;
import data.Iterations;
import data.TestData;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import platformLayer.ResourceLayer;
import resourceLayer.Endpoints;
import resourceLayer.Resources;
import vaccineSlotChecker.CovidVaccineSlotChecker;

import java.awt.*;

public class SlotChecker extends ResourceLayer {


    public void getCoWinVaccinationSlots(String distId, int iterations, long timeInt) throws InterruptedException {

        String testEndpoint = Resources.coWinHost + Endpoints.endpoint + "?district_id=" + distId + "&date=" + TestData.datePicker();

        for (int a = 0; a < iterations; a++) {
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
                CovidVaccineSlotChecker.textArea.append("Total Available slots: " + availableSlots.length()+ "\n");
                CovidVaccineSlotChecker.textArea.append("Slot details: " + availableSlots + "\n");
                CovidVaccineSlotChecker.textArea.append("******************************************************************************************************\n");
                CovidVaccineSlotChecker.lblSlotsAreAvailable.setText("Slots are available !!!!");
                CovidVaccineSlotChecker.lblLoginTo.setText("Login to https://selfregistration.cowin.gov.in/ and book your slots");
                Toolkit.getDefaultToolkit().beep();
            } else {
                CovidVaccineSlotChecker.textArea.append("Slots are Not available currently \n");
            }

            Thread.sleep(timeInt);

        }
        CovidVaccineSlotChecker.textArea.append("***********The Vaccination slot check is completed*************\n");

    }



}
