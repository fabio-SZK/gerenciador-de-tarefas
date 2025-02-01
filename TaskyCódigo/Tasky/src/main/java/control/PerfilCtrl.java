package control;

import model.Perfil;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class PerfilCtrl{
    private String nome;
    private String descricao;
    private String funcao;
    private ConexaoSQL conexao;

    public PerfilCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }

    public void adicionar(Usuario usuario){
        String sql = "INSERT INTO perfil (nome, descricao, funcao, idusuario) VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, "");
            pstmt.setString(3, "");
            pstmt.setInt(4, usuario.getIdUsuario());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void atualizar(Usuario usuario, Perfil perfil){
        String sql = "UPDATE perfil SET nome = ?, descricao = ?, funcao = ? WHERE idusuario = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setString(1, perfil.getNome());
            pstmt.setString(2, perfil.getDescricao());
            pstmt.setString(3, perfil.getFuncao());
            pstmt.setInt(4, usuario.getIdUsuario());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
    }
    
    public void remover(Perfil perfil){
        String sql = "DELETE FROM perfil WHERE idperfil = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            pstmt.setInt(1, perfil.getIdPerfil());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public ResultSet consultar(){
        String sql = "SELECT * FROM perfil";
        
        try{
            Statement stmt = conexao.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            return rs;
            
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public Perfil selecionar(Usuario usuario){
        String sql = "SELECT nome, descricao, funcao FROM perfil WHERE idusuario = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, usuario.getIdUsuario());
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String funcao = rs.getString("funcao");
                
                Perfil perfil = new Perfil();
                
                perfil.setNome(nome);
                perfil.setDescricao(descricao);
                perfil.setFuncao(funcao);
                
                return perfil;
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
}