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
 * CalculatingService has the application logic for delivering the data to be written
 *
 */
package service;

import model.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CalculatingService {

    private final List<List<Object>> resultsList;

    public CalculatingService(@NotNull List<List<Object>> resultsList) {
        this.resultsList = resultsList;
    }

    public List<List<Object>> studentSituation() {

        List<List<Object>> writingValues = new ArrayList<>();

        int numberOfStudents = resultsList.size();
        int countDone = 0;

        for (List<Object> row : resultsList) {

            Student student = new Student();

            student.setSituation(row);

            row.add(student.getSituacao());
            row.add(student.getNaf());

            writingValues.add(row);

            countDone++;
            System.out.println(countDone + " of " + numberOfStudents + " done. ");
        }
        return writingValues;
    }
}
