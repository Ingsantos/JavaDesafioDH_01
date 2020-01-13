package br.com.Desafio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {

    //Atributos
    private String nome;
    private Integer codigoCurso;
    private ProfessorAdjunto professorAdjunto;
    private ProfessorTitular professorTitular;
    private Integer quantidadeMaxAlunos;
    private List<Aluno> listaAlunosMatriculados = new ArrayList<>();

    //Construtor
    public Curso(String nome, Integer codigoCurso, Integer quantidadeMaxAlunos) {
        this.nome = nome;
        this.codigoCurso = codigoCurso;
        this.quantidadeMaxAlunos = quantidadeMaxAlunos;
    }

    //Getters and Setters

    public String getNome() {
        return nome;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    //Sobrescrita metodo Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(codigoCurso, curso.codigoCurso);
    }

    //Metodos
    private boolean encontrarAluno (Aluno umAluno){
        if (listaAlunosMatriculados.contains(umAluno)){
            System.out.println("Aluno já está matriculado neste curso.");
            return true;
        }
        return false;
    }

    private boolean cursoCheio() {
        if (listaAlunosMatriculados.size() < quantidadeMaxAlunos){
            return false;
        }
        System.out.println("Curso cheio!");
        return true;
    }

    public Boolean adicionarUmAluno(Aluno umAluno){
        if (!encontrarAluno(umAluno) && !cursoCheio()){
            listaAlunosMatriculados.add(umAluno);
            //System.out.println("Aluno adicionado com SUCESSO!");
            return true;
        } else {
            System.out.println("Matricula não efetivada!");
            return false;
        }
    }

    public void excluirAluno(Aluno umAluno){
        if(encontrarAluno(umAluno)) {
            listaAlunosMatriculados.remove(umAluno);
            System.out.println("Aluno foi removido da Lista de Alunos Matriculados!");
        } else {
            System.out.println("Aluno não está matriculado neste curso, logo não pode ser removido.");
        }

    }

}
