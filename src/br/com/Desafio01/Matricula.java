package br.com.Desafio01;

import java.util.Date;

public class Matricula {

    //Atributos
    private Aluno aluno;
    private Curso curso;
    private Date data;

    //Construtor
    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.data = new Date();
    }

    //Getters e Setters


    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

}
