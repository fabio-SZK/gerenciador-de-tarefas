package model;
import java.util.Date;

public class Tarefa {
    private int idTarefa;
    private Date prazoEntrega;
    private String descricao;
    private String prioridade;
    private Date dataCriacao;

    private Usuario usuario;
    private Equipe equipe;
    private Projeto projeto;

    public Tarefa(int idTarefa, Date prazoEntrega, String descricao, String prioridade, Date dataCriacao, Usuario usuario, Equipe equipe, Projeto projeto) {
        this.idTarefa = idTarefa;
        this.prazoEntrega = prazoEntrega;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.equipe = equipe;
        this.projeto = projeto;
    }
 
    public Tarefa() {
        this.idTarefa = 0;
        this.prazoEntrega = new Date();
        this.descricao = "";
        this.prioridade = "";
        this.dataCriacao = new Date();
        this.usuario = new Usuario();
        this.equipe = new Equipe();
        this.projeto = new Projeto();
    }
    
    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public Date getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(Date prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    
    
    public void criarTarefa() {
        // Implementação aqui
    }

    public void consultarTarefa() {
        // Implementação aqui
    }

    public void calcularTempo() {
        // Implementação aqui
    }

    public void deletarTarefa() {
        // Implementação aqui
    }

    public void alterarTarefa() {
        // Implementação aqui
    }

    public void listarTarefa() {
        // Implementação aqui
    }
}