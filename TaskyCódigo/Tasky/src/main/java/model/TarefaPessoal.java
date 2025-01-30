package model;

import java.util.Date;

public class TarefaPessoal extends Tarefa {
    private String recorrencia;
    private String local;

    public TarefaPessoal(String recorrencia, String local, int idTarefa, Date prazoEntrega, String descricao, String prioridade, Date dataCriacao, Usuario usuario, Equipe equipe, Projeto projeto) {
        super(idTarefa, prazoEntrega, descricao, prioridade, dataCriacao, usuario, equipe, projeto);
        this.recorrencia = recorrencia;
        this.local = local;
    }

    public TarefaPessoal() {
        super();
        this.recorrencia = "";
        this.local = "";
    }

    

    
    
    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    

    public void criarTarefaPessoal() {
        // Implementação aqui
    }
}