/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import model.Equipe;
import model.Projeto;
import model.TarefaPessoal;
import model.Usuario;

/**
 *
 * @author Fabio
 */
public class TarefaPessoalCtrl {
    private ConexaoSQL conexao;

    public TarefaPessoalCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }
    
      public void adicionar(TarefaPessoal tarefa){
        String sql1 = "INSERT INTO tarefa (prazoentrega, descricao, prioridade, datacriacao, idusuario, idequipe, idprojeto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO tarefapessoal (idtarefa, recorrencia, local) VALUES (?, ?, ?)";
        
        try{
            PreparedStatement pstmt1 = conexao.getConn().prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstmt2 = conexao.getConn().prepareStatement(sql2);    
            

            pstmt1.setDate(1, new java.sql.Date(tarefa.getPrazoEntrega().getTime()));
            pstmt1.setString(2, tarefa.getDescricao());
            pstmt1.setString(3, tarefa.getPrioridade());
            pstmt1.setDate(4, new java.sql.Date(tarefa.getDataCriacao().getTime()));
            pstmt1.setInt(5, tarefa.getUsuario().getIdUsuario());
            pstmt1.setObject(6, tarefa.getEquipe().getIdEquipe(), java.sql.Types.INTEGER);
            pstmt1.setObject(7, tarefa.getProjeto().getIdProjeto(), java.sql.Types.INTEGER);
            
            pstmt1.executeUpdate();
            
            ResultSet rs = pstmt1.getGeneratedKeys();
            
            if(rs.next()){
                int idTarefa = rs.getInt(1);
            
                pstmt2.setInt(1, idTarefa);
                pstmt2.setString(2, tarefa.getRecorrencia());
                pstmt2.setString(3, tarefa.getLocal());
            
                pstmt2.execute();
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    
    }
    
    public void remover(TarefaPessoal tarefa){
        String sql = "DELETE FROM tarefa WHERE idtarefa = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            pstmt.setInt(1, tarefa.getIdTarefa());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void atualizar(TarefaPessoal tarefa){
        String sql1 = "UPDATE tarefa SET idtarefa = ?, prazoentrega = ?, descricao = ?, prioridade = ?, datacriacao = ?, idusuario = ?, idequipe = ?, idprojeto = ? WHERE idtarefa = ?";
        String sql2 = "UPDATE tarefapessoal SET idtarefa = ?, recorrencia = ?, local = ? WHERE idtarefa = ?";
        
        try{
            PreparedStatement pstmt1 = conexao.getConn().prepareStatement(sql1);
            PreparedStatement pstmt2 = conexao.getConn().prepareStatement(sql2);    
            
            pstmt1.setInt(1, tarefa.getIdTarefa());
            pstmt1.setDate(2, new java.sql.Date(tarefa.getPrazoEntrega().getTime()));
            pstmt1.setString(3, tarefa.getDescricao());
            pstmt1.setString(4, tarefa.getPrioridade());
            pstmt1.setDate(5, new java.sql.Date(tarefa.getDataCriacao().getTime()));
            pstmt1.setInt(6, tarefa.getUsuario().getIdUsuario());
            pstmt1.setInt(7, tarefa.getEquipe().getIdEquipe());
            pstmt1.setInt(8, tarefa.getProjeto().getIdProjeto());
            pstmt1.setInt(9, tarefa.getIdTarefa());
            
            pstmt1.execute();
            
            pstmt2.setInt(1, tarefa.getIdTarefa());
            pstmt2.setString(2, tarefa.getRecorrencia());
            pstmt2.setString(3, tarefa.getLocal());
            pstmt2.setInt(4, tarefa.getIdTarefa());
            
            pstmt2.execute();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public TarefaPessoal consultarTarefa(int idTarefa){

        EquipeCtrl equipeDAO = new EquipeCtrl();
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        
        
        String sql = """
            SELECT t.idtarefa, t.prazoentrega, t.descricao, t.prioridade, t.datacriacao, t.idusuario, t.idequipe, t.idprojeto, tp.recorrencia, tp.local
            FROM tarefa t
            LEFT JOIN tarefapessoal tp ON tp.idtarefa = t.idtarefa
            WHERE t.idtarefa = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, idTarefa);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                idTarefa = rs.getInt("idtarefa");
                Date prazoentrega = rs.getDate("prazoentrega");
                String descricao = rs.getString("descricao");
                String prioridade = rs.getString("prioridade");
                Date datacriacao = rs.getDate("datacriacao");
                Usuario tUsuario = usuarioDAO.consultarUsuario(rs.getInt("idusuario"));
                Equipe equipe = equipeDAO.consultarEquipe(rs.getInt("idequipe"));
                Projeto projeto = projetoDAO.consultarProjeto(rs.getInt("idprojeto"));
                
                TarefaPessoal tarefa;
                
                
                tarefa = new TarefaPessoal(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("recorrencia"), rs.getString("local"));

                return tarefa;
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
}
