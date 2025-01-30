package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
    private int idProjeto;
    private String nome;
    private String descricao;
    private Date dataCriacao;
    private Date dataUltima;
    private List<Usuario> liderProjeto;
    private String objetivo;
    
    private List<Usuario> membrosProjeto;
    private List<Equipe> equipesProjeto;
    private List<Tarefa> listaTarefasProjeto;

    public Projeto(int idProjeto, String nome, String descricao, Date dataCriacao, Date dataUltima, List<Usuario> liderProjeto, String objetivo, List<Usuario> membrosProjeto, List<Equipe> equipesProjeto, List<Tarefa> listaTarefasProjeto) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataUltima = dataUltima;
        this.liderProjeto = liderProjeto;
        this.objetivo = objetivo;
        this.membrosProjeto = membrosProjeto;
        this.equipesProjeto = equipesProjeto;
        this.listaTarefasProjeto = listaTarefasProjeto;
    }
    
    public Projeto() {
        idProjeto = 0;
        nome = "";
        descricao = "";
        dataCriacao = new Date();
        dataUltima = new Date();
        liderProjeto = new ArrayList<>();
        objetivo = "";
        membrosProjeto = new ArrayList<>();
        equipesProjeto = new ArrayList<>();
        this.listaTarefasProjeto = new ArrayList<>();
    }

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

    public List<Usuario> getLiderProjeto() {
        return liderProjeto;
    }

    public void setLiderProjeto(List<Usuario> liderProjeto) {
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

    public List<Equipe> getEquipesProjeto() {
        return equipesProjeto;
    }

    public void setEquipesProjeto(List<Equipe> equipesProjeto) {
        this.equipesProjeto = equipesProjeto;
    }
    
    

    public List<Usuario> getMembrosProjeto() {
        return membrosProjeto;
    }

    public void setMembrosProjeto(List<Usuario> membrosProjeto) {
        this.membrosProjeto = membrosProjeto;
    }

    public List<Tarefa> getListaTarefasProjeto() {
        return listaTarefasProjeto;
    }

    public void setListaTarefasProjeto(List<Tarefa> listaTarefasProjeto) {
        this.listaTarefasProjeto = listaTarefasProjeto;
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