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
 * @entity
 * Student has the business logic for the the object's state and behaviour
 *
 */
package model;

import org.jetbrains.annotations.NotNull;
import service.ReadingService;

import java.util.List;

public class Student {

    private String situacao;
    private String naf;


    public Student(){
        situacao = "";
        naf = "";
    }

    public String getSituacao() {
        return situacao;
    }

    public String getNaf() {
        return naf;
    }

    public void setSituation(@NotNull List<Object> row) {

        int lectures = ReadingService.getLectures(); // 60

        int thresholdFaltas = (int)Math.round(0.25 * lectures);
        int faltas = Integer.parseInt((String)row.get(2));

        if ( faltas > thresholdFaltas ) {
            situacao = "Reprovado por Falta";
            naf = "0";
        } else {

            float p1 = Float.parseFloat((String) row.get(3));
            float p2 = Float.parseFloat((String) row.get(4));
            float p3 = Float.parseFloat((String) row.get(5));

            int media = Math.round((p1 + p2 + p3) / 3);

            if (media < 50) {
                situacao = "Reprovado por Nota";
                naf = "0";

            } else {
                if (media < 70) {
                    situacao = "Exame Final";
                    naf = Integer.toString(100 - media);

                } else { // (media >= 70)
                    situacao = "Aprovado";
                    naf = "0";

                }
            }
        }
    }
}
