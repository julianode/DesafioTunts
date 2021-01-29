package service;

import com.google.api.services.sheets.v4.Sheets;
import controller.StudentController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingService {

    private String spreadsheetId;
    private String range;
    private static String lectures;

    public ReadingService(String spreadsheetId, String range) {
        this.spreadsheetId = spreadsheetId;
        this.range = range;
    }

    public void readingSetUp() {

        boolean changedFromDefault = false;

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Would you like to change the target Spreadsheet? y / n");
            String wantsNewSpreadsheet = input.next();

            if (wantsNewSpreadsheet.equals("y")) {
                System.out.print("Please insert new target Spreadsheet ID: ");
                spreadsheetId = input.next();
                changedFromDefault = true;

            } else {
                System.out.println("Ok, using default Spreadsheet ID. \n");
            }

            System.out.println("Would you like to change the target selection area? y / n");
            String wantsNewSelectionArea = input.next();

            if (wantsNewSelectionArea.equals("y")) {
                System.out.print("Using the model showed above, please insert new target selection area: ");
                range = input.next();
                changedFromDefault = true;

            } else {
                System.out.println("Ok, using default selection area. \n");
            }

        } catch (Exception e) {
            System.err.println("Something went wrong, please try again.");
        }

        if (changedFromDefault == true) {
            System.out.println("\n");
            System.out.println("The target Spreadsheet ID is: " + spreadsheetId);
            System.out.println("The target selection area is: " + range);
        }
    }


    public List<List<Object>> listAll() {

        List<List<Object>> resultsList = new ArrayList<>();

        try {
            /**
             * There will be a Warning here. This is due to Windows use.
             *
             * My search conclusion is:
             * The Google library deals with POSIX systems and are not well set for Windows.
             * However, it still works.
             *
             * I tried to use @SuppressWarnings("uncheck"), and "deprecation" too, but I was not successful.
             */
            StudentController studentController = new StudentController();
            Sheets clientService = studentController.clientService(spreadsheetId, range);

            List<List<Object>> values = studentController.readSheet(clientService, spreadsheetId, range);
            if (values == null || values.isEmpty()) {
                System.out.println("No data found.");
            } else {
                System.out.println(""); // just to get space from the warning
                System.out.println(values.size() + " student(s) found."); // just to get space from the warning
                for (List<Object> row : values) {
                    // Prints Matrícula and Aluno, then a table with other fields.
                    System.out.println("Mat., Aluno");
                    System.out.printf(" %s , %s\n", row.get(0), row.get(1));
                    System.out.println(" Falt , P1 , P2, P3 ");
                    System.out.printf("   %s , %s , %s , %s \n\n",
                            row.get(2), row.get(3), row.get(4), row.get(5));
                }
            }
            resultsList = values;
        }
        catch (IOException | GeneralSecurityException excep) {
            System.err.println("Something went wrong, please try again. Java class: " + excep.toString());
        }

        return resultsList;
    }

    public void setLectures() {

        String lectureRange = range.substring(0,23) + "A2"; // "engenharia_de_software!A2"

        try {
            StudentController studentController = new StudentController();
            Sheets clientService = studentController.clientService(spreadsheetId, lectureRange);

            List<List<Object>> values = studentController.readSheet(clientService, spreadsheetId, lectureRange);
            if (values == null || values.isEmpty()) {
                System.out.println("No data found.");
            } else {
                System.out.println(""); // just to get space from the warning
                System.out.println(values.size() + " - lectures found."); // just to get space from the warning
                for (List<Object> row : values) {
                    ReadingService.lectures = (String) row.get(0);
                }
            }
        }
        catch (IOException | GeneralSecurityException excep) {
            System.err.println("Something went wrong, please try again. Java class: " + excep.toString());
        }
    }

    public static int getLectures() {

        int intLectures = Integer.parseInt(lectures.substring(28,30)); // 60

        return intLectures;
    }
}
