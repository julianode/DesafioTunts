package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class CalculatingService {

    private List<List<Object>> resultsList;

    public CalculatingService(List<List<Object>> resultsList) {
        this.resultsList = resultsList;
    }

    public List<List<Object>> situation() {

        List<List<Object>> writingValues = new ArrayList<>();

        int lectures = ReadingService.getLectures(); // 60
        int numberOfStudents = resultsList.size();
        int countDone = 0;

        for (List row : resultsList) {

            Student student = new Student((String)row.get(0), (String)row.get(1),
                                          (String)row.get(2), (String)row.get(3),
                                          (String)row.get(4), (String)row.get(5));

            int thresholdFaltas = (int)Math.round(0.25 * lectures);
            if (Integer.parseInt(student.getFaltas()) > thresholdFaltas) {
                student.setSituacao("Reprovado por Falta");
                student.setNaf("0");
            }
            //TODO THERE IS A BUG HERE. MEDIA IS NOT CORRECTLY CALCULATED
            int media = Math.round((Integer.parseInt(student.getP1())
                    + Integer.parseInt(student.getP1())
                    + Integer.parseInt(student.getP1())) / 3);

            if (media < 50) {
                student.setSituacao("Reprovado por Nota");
                student.setNaf("0");

            } else {
                if (media < 70) {
                    student.setSituacao("Exame Final");
                    student.setNaf(Integer.toString(100-media));

                } else {
                    if (media >= 70) {
                        student.setSituacao("Aprovado");
                        student.setNaf("0");
                    }
                }
            }

            List<Object> objectRow = new ArrayList();
            objectRow.add(student.getMatricula());
            objectRow.add(student.getAluno());
            objectRow.add(student.getFaltas());
            objectRow.add(student.getP1());
            objectRow.add(student.getP2());
            objectRow.add(student.getP3());
            objectRow.add(student.getSituacao());
            objectRow.add(student.getNaf());

            writingValues.add(objectRow);

            countDone++;
            System.out.println(countDone + " of " + numberOfStudents + " done. Média: "
                    + media + " do aluno " + student.getAluno());
        }
        return writingValues;
    }
}
