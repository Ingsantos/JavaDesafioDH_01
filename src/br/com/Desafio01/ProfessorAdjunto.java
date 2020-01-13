package br.com.Desafio01;

public class ProfessorAdjunto extends Professor{

    //Atributos
    protected Integer quantidadeHorasMentoria;

    //Construtor

    public ProfessorAdjunto(String nome, String sobrenome, Integer tempoCasa, Integer codigoProfessor, Integer quantidadeHorasMentoria) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tempoCasa = tempoCasa;
        this.codigoProfessor = codigoProfessor;
        this.quantidadeHorasMentoria = quantidadeHorasMentoria;
    }



}
