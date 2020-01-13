package br.com.Desafio01;

import br.com.digitalhouse.DHException;
import br.com.digitalhouse.DigitalException;
import br.com.digitalhouse.OtherException;

public class ClasseDeTeste {

    public static void main(String[] args) {

        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();

        System.out.println("-------------------------- REGISTRAR CURSO --------------------------");
        digitalHouseManager.registrarCurso("Full Stack", 20001, 3);
        digitalHouseManager.registrarCurso("Android", 20002, 2);

        System.out.println("\n-------------------------- REGISTRAR PROFESSOR --------------------------");
        digitalHouseManager.registrarProfessorTitular("Jess", "Corrêa", 2594, "Desenvolvimento Mobile");
        digitalHouseManager.registrarProfessorTitular("Priscila", "Alcantara", 1234, "Agile");
        digitalHouseManager.registrarProfessorAdjunto("João", "Felipe", 1803, 6);
        digitalHouseManager.registrarProfessorAdjunto("Alexandre", "Brincalepe", 7890, 4);

        System.out.println("\n-------------------------- ALOCAR PROFESSOR --------------------------");
        System.out.println("*                         PRIMEIRA ALOCAÇÃO                         *");
        digitalHouseManager.alocarProfessores(20001, 2594, 1803);
        System.out.println("*                         SEGUNDA ALOCAÇÃO                          *");
        digitalHouseManager.alocarProfessores(20002,1234,7890);

        System.out.println("\n-------------------------- MATRICULAR ALUNOS NA DH --------------------------");
        digitalHouseManager.matricularAluno("Inghridy", "Santos", 2601);
        digitalHouseManager.matricularAluno("Anderson", "Bittencourt", 3003);
        digitalHouseManager.matricularAluno("Keile", "Lima", 3208);

        System.out.println("\n-------------------------- MATRICULAR ALUNOS AOS CURSOS OFERECIDOS --------------------------");
        System.out.println("*                                      PRIMEIRO CURSO                                         *");
        digitalHouseManager.matricularAluno(2601, 20002);
        digitalHouseManager.matricularAluno(3003, 20002);
        digitalHouseManager.matricularAluno(3208, 20002);
        System.out.println("*                                      SEGUNDO CURSO                                          *");
        digitalHouseManager.matricularAluno(2601, 20001);
        digitalHouseManager.matricularAluno(3003, 20001);

        System.out.println("\n-------------------------- Aluno consulta  --------------------------");
        Aluno aluno1 = digitalHouseManager.encontrarAlunoCodigo(2601);
        aluno1.consultarMatriculas();
        Aluno aluno2 = digitalHouseManager.encontrarAlunoCodigo(3003);
        aluno2.consultarMatriculas();
        Aluno aluno3 = digitalHouseManager.encontrarAlunoCodigo(3208);
        aluno3.consultarMatriculas();

        System.out.println("\n-------------------------- ESTUDIOSO  --------------------------");
        try {
            DigitalException.matriculaDH(aluno1);
        }catch(DHException dhe){
            System.out.println("Vir ao co-learning");
        }catch(OtherException oe){
            System.out.println("Falar com os alunos");
        }

        try {
            DigitalException.matriculaDH(aluno3);
        }catch(DHException dhe){
            System.out.println("Vir ao co-learning");
        }catch(OtherException oe){
            System.out.println("Falar com os alunos");
        }

    }
}
