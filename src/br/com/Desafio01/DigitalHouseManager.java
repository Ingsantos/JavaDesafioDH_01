package br.com.Desafio01;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    //Atribuitos
    private List<Aluno> listaAlunos = new ArrayList<>();
    private List<Professor> listaProfessores = new ArrayList<>();
    private List<Curso> listaCursos = new ArrayList<>();
    private List<Matricula> listaMatriculas = new ArrayList<>();

    //Construtor

    //Getters and Setters

    //Metodos
    private boolean encontrarCursoCodigo(Integer codigoCurso){
        for (Curso curso: listaCursos){
            if (curso.getCodigoCurso().equals(codigoCurso)){
                return true;
            }
        }
        return false;
    }


    public void registrarCurso(String nome, Integer codigoCurso, Integer quantidadeMaximaDeAlunos){
        Curso curso = new Curso(nome, codigoCurso, quantidadeMaximaDeAlunos);
        if (encontrarCursoCodigo(codigoCurso)){
            System.out.println("Não podemos registrar o curso, pois já existe na lista de Cursos");
        } else {
            listaCursos.add(curso);
            System.out.println("Curso COD " + curso.getCodigoCurso() + " - " + curso.getNome() + " registrado com SUCESSO!");
        }
    }


    public void excluirCurso(Integer codigoCurso){
        for (Curso curso: listaCursos) {
            if (curso.getCodigoCurso().equals(codigoCurso) && encontrarCursoCodigo(codigoCurso)){
                System.out.println("Curso COD " + curso.getCodigoCurso() + " - " + curso.getNome() + " excluído com SUCESSO!");
                listaCursos.remove(curso);
                return;
            }
        }
        System.out.println("Curso não existe na lista de cursos oferecidos.");
    }


    private Boolean encontrarProfessorCodigo (Integer codigoProfessor){
        for (Professor professor: listaProfessores) {
            if (professor.getCodigoProfessor().equals(codigoProfessor)){
                return true;
            }
        }
        return false;
    }

    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoProfessor, Integer quantidadeDeHoras){

        ProfessorAdjunto professorAdjunto = new ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras);

        if (encontrarProfessorCodigo(codigoProfessor)) {
            System.out.println("Professor(a) Adjunto(a) COD " + professorAdjunto.getCodigoProfessor() + " - " + professorAdjunto.getNome() + " já está registrado(a) na lista de professores.");
        } else {
            listaProfessores.add(professorAdjunto);
            System.out.println("Professor(a) Adjunto(a) COD " + professorAdjunto.getCodigoProfessor() + " - " + professorAdjunto.getNome() + " registrado(a) na lista de professores com SUCESSO!");
        }
    }

    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProfessor, String especialidade){
        ProfessorTitular professorTitular = new ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade);

        if (encontrarProfessorCodigo(codigoProfessor)) {
            System.out.println("Professor(a) Titular COD " + professorTitular.getCodigoProfessor() + " - " + professorTitular.getNome() + " já está registrado(a) na lista de professores.");
        } else {
            listaProfessores.add(professorTitular);
            System.out.println("Professor(a) Titular COD " + professorTitular.getCodigoProfessor() + " - " + professorTitular.getNome() + " registrado(a) na lista de professores com SUCESSO!");
        }
    }

    public void excluirProfessor(Integer codigoProfessor){
        for (Professor professor: listaProfessores) {
            if (professor.getCodigoProfessor().equals(codigoProfessor) && encontrarProfessorCodigo(codigoProfessor)){
                System.out.println("Professor(a) COD " + professor.getCodigoProfessor()
                        + " - " + professor.getNome() + " excluído(a) com SUCESSO!");
                listaProfessores.remove(professor);
                return;
            }
        }
        System.out.println("Não foi possível excluir professor(a), pois este(a) não está registrado(a) na lista de professores.");
    }

    public Aluno encontrarAlunoCodigo (Integer codigoAluno){
        for (Aluno aluno: listaAlunos) {
            if (aluno.getCodigoAluno().equals(codigoAluno)){
                return aluno;
            }
        }
        return null;
    }

    public void matricularAluno(String nome, String sobrenome, Integer codigoAluno){
        Aluno aluno = new Aluno(nome, sobrenome, codigoAluno);
        if (encontrarAlunoCodigo(codigoAluno)!=null){
            System.out.println("Aluno(a) COD " + aluno.getCodigoAluno() + " - " + aluno.getNome() + " já está resgistrado(a) na lista de Alunos.");
        } else {
            listaAlunos.add(aluno);
            System.out.println("Aluno(a) COD " + aluno.getCodigoAluno() + " - " + aluno.getNome() + " registrado(a) a lista de alunos com SUCESSO!");
        }
    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso) {
        if (encontrarAlunoCodigo(codigoAluno)!=null){
            if (encontrarCursoCodigo(codigoCurso)){
                for (Curso curso: listaCursos){
                    if (curso.getCodigoCurso().equals(codigoCurso)){
                        for (Aluno aluno: listaAlunos){
                            if (aluno.getCodigoAluno().equals(codigoAluno)){
                                if (curso.adicionarUmAluno(aluno)){
                                    Matricula matricula = new Matricula(aluno, curso);
                                    listaMatriculas.add(matricula);
                                    List<Matricula> listaMatriculaAluno = aluno.getListaMatriculasAluno();
                                    listaMatriculaAluno.add(matricula);
                                    aluno.setListaMatriculasAluno(listaMatriculaAluno);
                                    System.out.println("Aluno COD " + aluno.getCodigoAluno() + " - " + aluno.getNome() +
                                            " matriculado ao curso COD " + curso.getCodigoCurso() + " - " + curso.getNome() +
                                            " com SUCESSO!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto){
        if (encontrarCursoCodigo(codigoCurso) && encontrarProfessorCodigo(codigoProfessorAdjunto) && encontrarProfessorCodigo(codigoProfessorTitular)){
            criarAlocacao(codigoCurso, codigoProfessorTitular, codigoProfessorAdjunto);
        } else {
            System.out.println("Por favor, verificar novamente, pois Curso ou Professor não está registrado");
        }
    }

    private void criarAlocacao(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto) {
        for (Curso curso: listaCursos) {
            for (Professor professor: listaProfessores) {
                if (curso.getCodigoCurso().equals(codigoCurso) && professor.getCodigoProfessor().equals(codigoProfessorTitular)){
                    curso.setProfessorTitular((ProfessorTitular) professor);
                    System.out.println("Professor(a) Titular COD " + professor.getCodigoProfessor() + " - " + professor.getNome() +
                            " registrado(a) ao curso COD " + curso.getCodigoCurso() + " - " + curso.getNome() + " com SUCESSO!");
                }
                if (curso.getCodigoCurso().equals(codigoCurso) && professor.getCodigoProfessor().equals(codigoProfessorAdjunto)){
                    curso.setProfessorAdjunto((ProfessorAdjunto) professor);
                    System.out.println("Professor(a) Adjunto(a) COD " + professor.getCodigoProfessor() + " - " + professor.getNome() +
                            " registrado(a) ao curso COD " + curso.getCodigoCurso() + " - " + curso.getNome() + " com SUCESSO!");
                }
            }
        }
    }

}

