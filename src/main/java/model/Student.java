package model;

import java.util.List;

public class Student {

    private String matricula;
    private String aluno;
    private String faltas;
    private String p1;
    private String p2;
    private String p3;
    private String situacao;
    private String naf; //Nota para Aprovação Final

    public Student(String matricula, String aluno, String faltas,
                   String p1,        String p2,    String p3) {

        this.matricula = matricula;
        this.aluno = aluno;
        this.faltas = faltas;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.situacao = "";
        this.naf = "";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getFaltas() {
        return faltas;
    }

    public void setFaltas(String faltas) {
        this.faltas = faltas;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNaf() {
        return naf;
    }

    public void setNaf(String naf) {
        this.naf = naf;
    }
}
