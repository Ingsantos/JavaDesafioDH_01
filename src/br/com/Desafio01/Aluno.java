package br.com.Desafio01;

import br.com.digitalhouse.Estudioso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno implements Estudioso {

    //Atributos

    private String nome;
    private String sobrenome;
    private Integer codigoAluno;
    private List<Matricula> listaMatriculasAluno = new ArrayList<>();

    //Construtor

    public Aluno(String nome, String sobrenome, Integer codigoAluno) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codigoAluno = codigoAluno;
    }

    //Getters e Setters

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public List<Matricula> getListaMatriculasAluno() {
        return listaMatriculasAluno;
    }

    public void setListaMatriculasAluno(List<Matricula> listaMatriculasAluno) {
        this.listaMatriculasAluno = listaMatriculasAluno;
    }

    //Sobreescrita Metodo Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(codigoAluno, aluno.codigoAluno);
    }

    //Metodo

    public void consultarMatriculas () {
        if (listaMatriculasAluno.size() > 0){
            for (Matricula matricula : listaMatriculasAluno) {
                System.out.println("Aluno (a): " + matricula.getAluno().getCodigoAluno() + " - " + matricula.getAluno().getNome() +
                        "  Curso: " + matricula.getCurso().getCodigoCurso() + " - " + matricula.getCurso().getNome());
            }
        }else {
            System.out.println("Aluno(a) COD " + getCodigoAluno() + " - " + getNome() + " não está matriculado(a) em nenhum curso.");
        }
    }

    @Override
    public float getNivelDeEstudo() {
        return (listaMatriculasAluno.size()*6.0f);
    }
}
