package controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class StudentController {

    // [Start] CREDENTIALS and AUTHORISATION by OAuth
    private static final String APPLICATION_NAME = "Java Client of Google Sheets API";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens/";

    /**
     * Global instance of the scopes required.
     * The chosen scope gives reading, and writing privileges.
     *
     * When first time users run the application, a browser window will open.
     * Google will ask for login and to accept the scope privileges.
     *
     * If modifying these scopes, delete your previously saved tokens/ folder.
     * When starting the application again, Google will ask to accept the new privileges.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static String valueInputOption = "USER_ENTERED";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = StudentController.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

        com.google.api.client.util.store.FileDataStoreFactory setPermissionsToOwnerOnly;
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    // [End] CREDENTIALS and AUTHORISATION by OAuth

    /**
     * ClientService - Google requires - Build a new authorized API client service.
     *
     * Exercise default parameters
     * @param spreadsheetId = "1FefNWWy06XGLzil4GPIfgErGSb5ZhNVH_cuVYnLNIHo";
     * @param range = "engenharia_de_software!A4:F27";
     */
    public Sheets clientService(String spreadsheetId,
                                String range) throws IOException, GeneralSecurityException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets clientService = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        return clientService;
    }


    /**
    * Reads values in the spreadsheet.
    */
    public List<List<Object>> readSheet(Sheets clientService,
                                            String spreadsheetId,
                                            String range) throws IOException {

        ValueRange response = clientService.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();
        List<List<Object>> values = response.getValues();

        return values;
    }

    /**
    * Writes values in the spreadsheet.
    */
    public UpdateValuesResponse writeData(String spreadsheetId,
                              String range,
                              List<List<Object>> writingValues,
                              Sheets clientService) throws IOException {

            /* Example of hard coded data.
            writingValues = Arrays.asList( // This array is a row.
                Arrays.asList( 35,  63, 61 ), // This array are the cell ex.: ( 1, 2, 3, 4 )
                Arrays.asList( 64,  97, 36 ), // or or ( "John, "Michel", "Peter"). They make the columns.
                Arrays.asList( 68,	74,	51 ),
                Arrays.asList( 66,	98,	62 ),
                Arrays.asList( 80,	65,	41 ),
                Arrays.asList( 83,	68,	77 ),
                Arrays.asList( 38,	53,	80 )
               );
             */

        ValueRange body = new ValueRange()
                .setValues(writingValues);
        UpdateValuesResponse result =
                clientService.spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption(valueInputOption)
                        .execute();

        return result;
    }
}
