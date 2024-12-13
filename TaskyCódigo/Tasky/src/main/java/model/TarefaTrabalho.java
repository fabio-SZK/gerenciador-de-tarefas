package model;
import java.util.Date;

public class TarefaTrabalho extends Tarefa {
    private String departamento;
    private Date prazoRevisao;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }   

    public Date getPrazoRevisao() {
        return prazoRevisao;
    }

    public void setPrazoRevisao(Date prazoRevisao) {
        this.prazoRevisao = prazoRevisao;
    }   
    
    public void criarTarefaTrabalho() {
        // Implementação aqui
    }
}