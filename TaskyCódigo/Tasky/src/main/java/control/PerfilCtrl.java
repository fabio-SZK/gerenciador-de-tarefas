package control;

import model.Perfil;

public class PerfilCtrl{
    private String nome;
    private String descricao;
    private String funcao;
    private ConexaoSQL conexao;

    public PerfilCtrl(){
        conexao.conectarBD();
    }

    public void adicionar(Perfil perfil){

    }
}