package br.com.Desafio01;

public class ProfessorTitular extends Professor{

    //Atributo
    protected String especialidade;

    //Construtor
    public ProfessorTitular(String nome, String sobrenome, Integer tempoCasa, Integer codigoProfessor, String especialidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tempoCasa = tempoCasa;
        this.codigoProfessor = codigoProfessor;
        this.especialidade = especialidade;
    }

    //Getter e Setter

}
