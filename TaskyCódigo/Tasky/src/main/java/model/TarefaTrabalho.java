package model;
import java.util.Date;

public class TarefaTrabalho extends Tarefa {
    private String departamento;
    private Date prazoRevisao;

    public TarefaTrabalho(String departamento, Date prazoRevisao, int idTarefa, Date prazoEntrega, String descricao, String prioridade, Date dataCriacao, Usuario usuario, Equipe equipe, Projeto projeto) {
        super(idTarefa, prazoEntrega, descricao, prioridade, dataCriacao, usuario, equipe, projeto);
        this.departamento = departamento;
        this.prazoRevisao = prazoRevisao;
    }

    public TarefaTrabalho() {
        super();
        this.departamento = "";
        this.prazoRevisao = new Date();
    }

    
    
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