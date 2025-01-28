package control;

import model.Projeto;
import java.util.Date;

public class ProjetoCtrl{
    private String nome;
    private String descricao;
    private Date dataCriacao;
    private Date dataUltima;
    private String liderProjeto;
    private int idProjeto;
    private String objetivo;
    private ConexaoSQL conexao;

    public ProjetoCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }

    public void adicionar(Projeto projeto){

    }
}