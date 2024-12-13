package model;
import java.util.Date;

public class Projeto {
    private String nome;
    private String descricao;
    private Date dataCriacao;
    private Date dataUltima;
    private String liderProjeto;
    private int idProjeto;
    private String objetivo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataUltima() {
        return dataUltima;
    }

    public void setDataUltima(Date dataUltima) {
        this.dataUltima = dataUltima;
    }

    public String getLiderProjeto() {
        return liderProjeto;
    }

    public void setLiderProjeto(String liderProjeto) {
        this.liderProjeto = liderProjeto;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    
    
    public void criarProjeto() {
        // Implementação aqui
    }

    public void consultarProjeto() {
        // Implementação aqui
    }

    public void deletarProjeto() {
        // Implementação aqui
    }

    public void alterarProjeto() {
        // Implementação aqui
    }

    public void definirLider() {
        // Implementação aqui
    }

    public void listarProjeto() {
        // Implementação aqui
    }
}