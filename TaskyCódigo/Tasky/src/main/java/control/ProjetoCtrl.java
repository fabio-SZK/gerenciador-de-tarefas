package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Projeto;
import java.util.Date;
import java.util.List;
import model.Equipe;
import model.Tarefa;
import model.Usuario;

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

    public void adicionar(Usuario usuario, Projeto projeto){
        String sql1 = "INSERT INTO projeto (idprojeto, nome, descricao, datacriacao, dataultima, objetivo) VALUES (?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO projetolider (idprojeto, idnome) VALUES (?, ?)";
        String sql3 = "INSERT INTO projetomembro (idprojeto, idnome) VALUES (?, ?)";
        
        try{
            PreparedStatement pstmt1 = conexao.getConn().prepareStatement(sql1);
            PreparedStatement pstmt2 = conexao.getConn().prepareStatement(sql2);
            PreparedStatement pstmt3 = conexao.getConn().prepareStatement(sql3);
            
            pstmt1.setInt(1, projeto.getIdProjeto());
            pstmt1.setString(2, projeto.getNome());
            pstmt1.setString(3, projeto.getDescricao());
            pstmt1.setDate(4, projeto.getDataCriacao());
            pstmt1.setDate(5, projeto.getDataUltima());
            pstmt1.setString(6, projeto.getObjetivo());
            
            pstmt1.execute();
            
            pstmt2.setInt(1, projeto.getIdProjeto());
            pstmt2.setInt(2, usuario.getIdUsuario());
            
            pstmt2.execute();
            
            pstmt3.setInt(1, projeto.getIdProjeto());
            pstmt3.setInt(2, usuario.getIdUsuario());
            
            pstmt3.execute();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void adicionarMembro(Usuario usuario, Projeto projeto){
        String sql = "INSERT INTO projetomembro (idprojeto, idnome) VALUES (?, ?)";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, projeto.getIdProjeto());
            pstmt.setInt(2, usuario.getIdUsuario());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            
        }
    }
    
        public void adicionarLider(Usuario usuario, Projeto projeto){
        String sql = "INSERT INTO projetolider (idprojeto, idnome) VALUES (?, ?)";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, projeto.getIdProjeto());
            pstmt.setInt(2, usuario.getIdUsuario());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            
        }
    }
    
    public void remover(Projeto projeto){
        String sql1 = "DELETE FROM projeto WHERE idprojeto = ?";
        String sql2 = "DELETE FROM projetolider WHERE idprojeto = ?";
        String sql3 = "DELETE FROM projetomembro WHERE idprojeto = ?";
        
        try{
            PreparedStatement pstmt1 = conexao.getConn().prepareStatement(sql1);
            PreparedStatement pstmt2 = conexao.getConn().prepareStatement(sql2);
            PreparedStatement pstmt3 = conexao.getConn().prepareStatement(sql3);

            pstmt1.setInt(1, projeto.getIdProjeto());
        
            pstmt1.executeUpdate();
            
            pstmt2.setInt(1, projeto.getIdProjeto());
        
            pstmt2.executeUpdate();
            
            pstmt3.setInt(1, projeto.getIdProjeto());
        
            pstmt3.executeUpdate();
            
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void atualizar(Projeto projeto){
        String sql = "UPDATE projeto SET nome = ?, descricao = ?, datacriacao = ?, dataultima = ?, objetivo = ? WHERE idprojeto = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setString(1, projeto.getNome());
            pstmt.setString(2, projeto.getDescricao());
            pstmt.setDate(3, projeto.getDataCriacao());
            pstmt.setDate(4, projeto.getDataUltima());
            pstmt.setString(5, projeto.getObjetivo());
            pstmt.setInt(6, projeto.getIdProjeto());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public ResultSet consultar(Usuario usuario){
        String sql = "SELECT projeto.idprojeto, nome, descricao, datacriacao, dataultima, objetivo FROM projeto JOIN projetomembro ON projeto.idprojeto = projetomembro.idprojeto WHERE projetomembro.idusuario = 1";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, usuario.getIdUsuario());
            
            ResultSet rs = pstmt.executeQuery();
            
            return rs;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public Projeto consultarProjeto(int idProjeto){
        
        
        return null;
    }
    
    public List<Usuario> consultarMembros(int idProjeto){
        
        return null;
    }
    
    public List<Usuario> consultarLideres(int idProjeto){
        
        return null;
    }
    
    public List<Equipe> consultarEquipes(int idProjeto){
        
        return null;
    }
    
    public List<Tarefa> consultarTarefas(int idProjeto){
        
        return null;
    }
}

