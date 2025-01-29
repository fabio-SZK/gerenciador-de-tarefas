package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Equipe;
import model.Perfil;
import model.Projeto;

public class EquipeCtrl{
    private String liderEquipe;
    private String areaAtuacao;
    private String descricao;
    private int idEquipe;
    private String funcao;
    private ConexaoSQL conexao;

    public EquipeCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }

    public void adicionar(Equipe equipe){
        String sql = "INSERT INTO equipe (idequipe, idliderequipe, areaatuacao, descricao, funcao, idprojeto) VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, equipe.getIdEquipe());
            pstmt.setInt(2, equipe.getLiderEquipe().getIdUsuario());
            pstmt.setString(3, equipe.getAreaAtuacao());
            pstmt.setString(4, equipe.getDescricao());
            pstmt.setString(5, equipe.getFuncao());
            pstmt.setInt(6, equipe.getProjeto().getIdProjeto());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void remover(Equipe equipe){
        String sql = "DELETE FROM equipe WHERE idequipe = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            pstmt.setInt(1, equipe.getIdEquipe());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public ResultSet consultar(Projeto projeto){
        String sql = "SELECT idequipe, idliderequipe, areaatuacao, descricao, funcao, idprojeto FROM equipe WHERE idprojeto = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, projeto.getIdProjeto());
            
            ResultSet rs = pstmt.executeQuery();
            
            return rs;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public void atualizar(Equipe equipe){
        String sql = "UPDATE equipe SET idliderequipe = ?, areaatuacao = ?, descricao = ?, funcao = ?, idprojeto = ? WHERE idequipe = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            pstmt.setInt(1, equipe.getLiderEquipe().getIdUsuario());
            pstmt.setString(2, equipe.getAreaAtuacao());
            pstmt.setString(3, equipe.getDescricao());
            pstmt.setString(4, equipe.getFuncao());
            pstmt.setInt(5, equipe.getProjeto().getIdProjeto());
            pstmt.setInt(6, equipe.getIdEquipe());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
}