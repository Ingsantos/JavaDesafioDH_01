package br.com.Desafio01;

import java.util.Objects;

public abstract class Professor {

    //Atributos
    protected String nome;
    protected String sobrenome;
    protected Integer tempoCasa;
    protected Integer codigoProfessor;

    //Construtor

    //Getters e Setters


    public Integer getCodigoProfessor() {
        return codigoProfessor;
    }

    public String getNome() {
        return nome;
    }

    //Sobrescrita metodo Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(codigoProfessor, professor.codigoProfessor);
    }

}
