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
public class TarefaAcademicaCtrl {
    private ConexaoSQL conexao;

    public TarefaAcademicaCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }
    
      public void adicionar(TarefaAcademica tarefa){
        String sql1 = "INSERT INTO tarefa (prazoentrega, descricao, prioridade, datacriacao, idusuario, idequipe, idprojeto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO tarefaacademica (idtarefa, materia, professor, nota) VALUES (?, ?, ?, ?)";
        
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
                pstmt2.setString(2, tarefa.getMateria());
                pstmt2.setString(3, tarefa.getProfessor());
                pstmt2.setDouble(4, tarefa.getNota());
            
                pstmt2.executeUpdate();
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    
    }
    
    public void remover(TarefaAcademica tarefa){
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
    
    public void atualizar(TarefaAcademica tarefa){
        String sql1 = "UPDATE tarefa SET idtarefa = ?, prazoentrega = ?, descricao = ?, prioridade = ?, datacriacao = ?, idusuario = ?, idequipe = ?, idprojeto = ? WHERE idtarefa = ?";
        String sql2 = "UPDATE tarefaacademica SET idtarefa = ?, materia = ?, professor = ?, nota = ? WHERE idtarefa = ?";
        
        try{
            PreparedStatement pstmt1 = conexao.getConn().prepareStatement(sql1);
            PreparedStatement pstmt2 = conexao.getConn().prepareStatement(sql2);    
            
            pstmt1.setDate(1, new java.sql.Date(tarefa.getPrazoEntrega().getTime()));
            pstmt1.setString(2, tarefa.getDescricao());
            pstmt1.setString(3, tarefa.getPrioridade());
            pstmt1.setDate(4, new java.sql.Date(tarefa.getDataCriacao().getTime()));
            pstmt1.setInt(5, tarefa.getUsuario().getIdUsuario());
            pstmt1.setInt(6, tarefa.getEquipe().getIdEquipe());
            pstmt1.setInt(7, tarefa.getProjeto().getIdProjeto());
            pstmt1.setInt(8, tarefa.getIdTarefa());
            
            pstmt1.execute();
            
            pstmt2.setInt(1, tarefa.getIdTarefa());
            pstmt2.setString(2, tarefa.getMateria());
            pstmt2.setString(3, tarefa.getProfessor());
            pstmt2.setDouble(4, tarefa.getNota());
            pstmt2.setInt(5, tarefa.getIdTarefa());
            
            pstmt2.execute();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public TarefaAcademica consultarTarefa(int idTarefa){

        EquipeCtrl equipeDAO = new EquipeCtrl();
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        
        
        String sql = """
            SELECT t.idtarefa, t.prazoentrega, t.descricao, t.prioridade, t.datacriacao, t.idusuario, t.idequipe, t.idprojeto, ta.materia, ta.professor, ta.nota
            FROM tarefa t
            LEFT JOIN tarefaacademica ta ON ta.idtarefa = t.idtarefa
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
                
                TarefaAcademica tarefa;
                
                
                tarefa = new TarefaAcademica(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("materia"), rs.getString("professor"), rs.getDouble("nota"));
                
                equipeDAO.getConexao().getConn().close(); //
                usuarioDAO.getConexao().getConn().close(); // 
                projetoDAO.getConexao().getConn().close(); //
                
                return tarefa;
            }
            equipeDAO.getConexao().getConn().close(); //
            usuarioDAO.getConexao().getConn().close(); // 
            projetoDAO.getConexao().getConn().close(); //
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
     public ConexaoSQL getConexao() {
        return conexao;
    }

    public void setConexao(ConexaoSQL conexao) {
        this.conexao = conexao;
    }
}
