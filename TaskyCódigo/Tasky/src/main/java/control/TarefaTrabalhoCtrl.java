/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Equipe;
import model.Projeto;
import model.Tarefa;
import model.TarefaAcademica;
import model.TarefaPessoal;
import model.TarefaTrabalho;
import model.Usuario;

/**
 *
 * @author Fabio
 */
public class TarefaTrabalhoCtrl {
    private ConexaoSQL conexao;

    public TarefaTrabalhoCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }
    
     public void adicionar(TarefaTrabalho tarefa){
        String sql1 = "INSERT INTO tarefa (idtarefa, prazoentrega, descricao, prioridade, datacriacao, idusuario, idequipe, idprojeto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO tarefatrabalho (idtarefa, departamento, prazorevisao) VALUES (?, ?, ?)";
        
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
            
            pstmt1.execute();
            
            pstmt2.setInt(1, tarefa.getIdTarefa());
            pstmt2.setString(2, tarefa.getDepartamento());
            pstmt2.setDate(3, new java.sql.Date(tarefa.getPrazoRevisao().getTime()));
            
            pstmt2.execute();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    
    }
    
    public void remover(TarefaTrabalho tarefa){
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
    
    public void atualizar(TarefaTrabalho tarefa){
        String sql1 = "UPDATE tarefa SET idtarefa = ?, prazoentrega = ?, descricao = ?, prioridade = ?, datacriacao = ?, idusuario = ?, idequipe = ?, idprojeto = ? WHERE idtarefa = ?";
        String sql2 = "UPDATE tarefatrabalho SET idtarefa = ?, departamento = ?, prazorevisao = ? WHERE idtarefa = ?";
        
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
            pstmt2.setString(2, tarefa.getDepartamento());
            pstmt2.setDate(3, new java.sql.Date(tarefa.getPrazoRevisao().getTime()));
            pstmt2.setInt(4, tarefa.getIdTarefa());
            
            pstmt2.execute();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public Tarefa consultarTarefa(int idTarefa){
        List<Tarefa> tarefas = new ArrayList<>();
        EquipeCtrl equipeDAO = new EquipeCtrl();
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        
        
        String sql = """
            SELECT t.idtarefa, t.prazoentrega, t.descricao, t.prioridade, t.datacriacao, t.idusuario, t.idequipe, t.idprojeto, ta.materia, ta.professor, ta.nota, tp.recorrencia, tp.local, tt.departamento, tt.prazorevisao
            FROM tarefa t
            LEFT JOIN tarefaacademica ta ON ta.idtarefa = t.idtarefa
            LEFT JOIN tarefapessoal tp ON tp.idtarefa = t.idtarefa
            LEFT JOIN tarefatrabalho tt ON tt.idtarefa = t.idtarefa
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
                
                Tarefa tarefa;
                
                if(rs.getString("materia") != null){
                    tarefa = new TarefaAcademica(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("materia"), rs.getString("professor"), rs.getDouble("nota"));
                    
                }
                else if(rs.getString("recorrencia") != null){
                    tarefa = new TarefaPessoal(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("recorrencia"), rs.getString("local"));
                }
                else if(rs.getString("departamento") != null){
                    tarefa = new TarefaTrabalho(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("departamento"), rs.getDate("datarevisao"));
                }
                else{
                    tarefa = new Tarefa(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto);
                }
                
                return tarefa;
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
}
