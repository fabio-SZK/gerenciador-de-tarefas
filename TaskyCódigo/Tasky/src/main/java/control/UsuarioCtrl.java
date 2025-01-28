package control;
import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioCtrl{
    private int idUsuario;
    private String nome;
    private String senha;
    private String email;
    private ConexaoSQL conexao;

    public UsuarioCtrl() throws SQLException{
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }
    
    public Usuario login(String usuario, String senha){
        String sql = "SELECT \"idUsuario\", nome, senha, email FROM usuario WHERE nome = ? AND senha = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            ResultSet rs = null;
            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            System.out.println("teste2");
            if(rs.next()){
                int idUsuario = rs.getInt("idUsuario");
                String email = rs.getString("email");
                      
                System.out.println("Login sucesso");
                return new Usuario(idUsuario, nome, senha, email);
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            // falha na autenticação
        }
        
        return null; // Autenticação falhada, usuário ou senha incorreto
    }
    
    public void adicionar(Usuario usuario){

    }
}