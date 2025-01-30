package model;

import java.util.Date;

public class TarefaAcademica extends Tarefa {
    
    private String materia;
    private String professor;
    private float nota;

    public TarefaAcademica(String materia, String professor, float nota, int idTarefa, Date prazoEntrega, String descricao, String prioridade, Date dataCriacao, Usuario usuario, Equipe equipe, Projeto projeto) {
        super(idTarefa, prazoEntrega, descricao, prioridade, dataCriacao, usuario, equipe, projeto);
        this.materia = materia;
        this.professor = professor;
        this.nota = nota;
    }

    public TarefaAcademica() {
        super();
        this.materia = "";
        this.professor = "";
        this.nota = 0;
    }

    
    
    
    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    
    public void criarTarefaAcademica() {
        // Implementação aqui
    }
}