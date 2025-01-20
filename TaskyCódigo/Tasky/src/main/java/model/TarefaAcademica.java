package model;

public class TarefaAcademica extends Tarefa {
    
    private String materia;
    private String professor;
    private float nota;
    
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