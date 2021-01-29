/**
 * Java Client of Google Sheets API
 *
 * @author Juliano Suman Curti
 * @creationDate january 2021
 * @version 0.1.0
 *
 * @license MIT License
 * @repository https://github.com/julianode/DesafioTunts
 *
 * @credentials One must have his own credentials to use the Google API service (OAuth).
 * Check src\resources\place_your_credentials_ here-README.txt for instructions.
 *
 * @service
 * WritingService has the application logic for writing the data on the sheet
 *
 */
package service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import controller.StudentController;

import java.security.GeneralSecurityException;
import java.util.List;
import java.io.IOException;

public class WritingService {

    private final String spreadsheetId;
    private final String range;

    public WritingService(String spreadsheetId, String range) {
        this.spreadsheetId = spreadsheetId;
        this.range = range;
    }

    public void writeData(List <List<Object>> writingValues) {
        try {
            StudentController studentController = new StudentController();
            Sheets clientService = studentController.clientService();

            UpdateValuesResponse result = studentController.writeData(spreadsheetId, range,
                                                                      writingValues, clientService);
            System.out.println("\n"); //just for spacing
            System.out.printf("%d cells updated. ", result.getUpdatedCells());
        }
        catch (IOException | GeneralSecurityException excep) {
            System.err.println("Something went wrong, please try again. Java class: " + excep.toString());
        }
    }
}
