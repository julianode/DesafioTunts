import service.ReadingService;

/**
 * Java Client of Google Sheets API
 *
 * @author Juliano Suman Curti
 * @creationDate 2021/01/28
 * @version 0.1.0
 *
 * @license MIT License
 * @repository https://github.com/julianode/DesafioTunts
 *
 * @Documented
 * This is a client application to consume Google Sheets API.
 * It is part of Tunts assessment for Java Back-end Developer position.
 * The architecture pattern applied is MVCS - (Model View Controller Service).
 *
 * @credentials One must have his own credentials to use the Google API service (OAuth).
 * Check src\resources\place_your_credentials_ here-README.txt for instructions.
 *
 * @view
 * ClientApplicationView is a basic command-line user interface.
 *
 */

public class ClientApplicationView {

    public static void main(String[] args) {

        /**
         * Exercise default parameters
         * @param spreadsheetId = "1FefNWWy06XGLzil4GPIfgErGSb5ZhNVH_cuVYnLNIHo";
         * @param range = "engenharia_de_software!A4:F27";
         */
        String spreadsheetId = "1FefNWWy06XGLzil4GPIfgErGSb5ZhNVH_cuVYnLNIHo";
        String range = "engenharia_de_software!A4:F27";

        System.out.println("\n ------- Java Client of Google Sheet API ------- \n");
        System.out.println("The target Spreadsheet ID is: " + spreadsheetId);
        System.out.println("\nThe target selection area is: " + range);
        System.out.println("(meaning: sheet_you_want ! rectangle_left_upper_corner : rectangle_right_lower_corner)\n");

        System.out.println("Now, doing Reading Setup\n\n");
        ReadingService readingService = new ReadingService();
        readingService.readingSetUp(spreadsheetId, range);

        System.out.println("\n"); // just for spacing
        System.out.println("Now, reading the spreadsheet\n\n");
        readingService.listAll(spreadsheetId, range);









    }
}
