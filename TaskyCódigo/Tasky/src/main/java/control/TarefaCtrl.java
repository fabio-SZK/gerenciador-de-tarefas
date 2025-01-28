package control;
import java.util.Date;
import model.Tarefa;

public class TarefaCtrl{
    private int idTarefa;
    private Date prazoEntrega;
    private String descricao;
    private String prioridade;
    private Date dataCriacao;
    private ConexaoSQL conexao;

    public TarefaCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }

    public void adicionar(Tarefa tarefa){
        
    }
}