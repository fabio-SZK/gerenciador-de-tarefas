import java.util.Date;

class Tarefa {
    private int idTarefa;
    private Date prazoEntrega;
    private String descricao;
    private String prioridade;
    private Date dataCriacao;

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