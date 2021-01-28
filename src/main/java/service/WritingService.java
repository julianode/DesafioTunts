package service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import controller.StudentController;

import java.security.GeneralSecurityException;
import java.util.List;
import java.io.IOException;

public class WritingService {

    private String spreadsheetId;
    private String range;

    public WritingService(String spreadsheetId, String range) {
        this.spreadsheetId = spreadsheetId;
        this.range = range;
    }

    public void writeData(List <List<Object>> writingValues) {
        try {
            StudentController studentController = new StudentController();
            Sheets clientService = studentController.clientService(spreadsheetId, range);

            UpdateValuesResponse result = studentController.writeData(spreadsheetId, range,
                                                                      writingValues, clientService);
            System.out.println("\n"); //just for spacing
            System.out.printf("%d cells updated. ", result.getUpdatedCells());
        }
        catch (IOException ioExcep) {
            System.err.println("Something went wrong, please try again. Java class: " + ioExcep.toString());
        }
        catch (GeneralSecurityException gsExcep) {
            System.err.println("Something went wrong, please try again. Java class: " + gsExcep.toString());
        }
    }
}
