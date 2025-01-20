package control;
import control.ConexaoSQL;

public class UsuarioCtrl{
    private int idUsuario;
    private String nome;
    private String senha;
    private String login;
    private String email;
    private ConexaoSQL conexao;

    public UsuarioCtrl(){
        conexao.conectarBD();
    }

    public void adicionar(Usuario usuario){

    }
}