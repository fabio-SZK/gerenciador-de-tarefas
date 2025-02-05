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

public class TarefaCtrl{
    
    private ConexaoSQL conexao;

    public TarefaCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }

    public void adicionar(Tarefa tarefa){
        String sql = "INSERT INTO tarefa (prazoentrega, descricao, prioridade, datacriacao, idusuario, idequipe, idprojeto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            
            pstmt.setDate(1, new java.sql.Date(tarefa.getPrazoEntrega().getTime()));
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setString(3, tarefa.getPrioridade());
            pstmt.setDate(4, new java.sql.Date(tarefa.getDataCriacao().getTime()));
            pstmt.setInt(5, tarefa.getUsuario().getIdUsuario());
            pstmt.setObject(6, tarefa.getEquipe().getIdEquipe(), java.sql.Types.INTEGER);
            pstmt.setObject(7, tarefa.getProjeto().getIdProjeto(), java.sql.Types.INTEGER);
            
            pstmt.execute();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    
    }
    
    public void remover(Tarefa tarefa){
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
    
    public void atualizar(Tarefa tarefa){
        String sql = "UPDATE tarefa SET idtarefa = ?, prazoentrega = ?, descricao = ?, prioridade = ?, datacriacao = ?, idusuario = ?, idequipe = ?, idprojeto = ? WHERE idtarefa = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, tarefa.getIdTarefa());
            pstmt.setDate(2, new java.sql.Date(tarefa.getPrazoEntrega().getTime()));
            pstmt.setString(3, tarefa.getDescricao());
            pstmt.setString(4, tarefa.getPrioridade());
            pstmt.setDate(5, new java.sql.Date(tarefa.getDataCriacao().getTime()));
            pstmt.setInt(6, tarefa.getUsuario().getIdUsuario());
            pstmt.setInt(7, tarefa.getEquipe().getIdEquipe());
            pstmt.setInt(8, tarefa.getProjeto().getIdProjeto());
            pstmt.setInt(9, tarefa.getIdTarefa());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public Tarefa consultarTarefa(int idTarefa){
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
                Equipe equipe;
                Projeto projeto;
                if(rs.getObject("idequipe", Integer.class) == null){
                    equipe = new Equipe();
                }
                else{
                    equipe = equipeDAO.consultarEquipe(rs.getInt("idequipe"));
                }
                if(rs.getObject("idprojeto", Integer.class) == null){
                    projeto = new Projeto();
                }
                else{
                    projeto = projetoDAO.consultarProjeto(rs.getInt("idprojeto"));
                }

                
                Tarefa tarefa;
                
                if(rs.getString("materia") != null){
                    tarefa = new TarefaAcademica(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("materia"), rs.getString("professor"), rs.getDouble("nota"));
                    
                }
                else if(rs.getString("recorrencia") != null){
                    tarefa = new TarefaPessoal(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("recorrencia"), rs.getString("local"));
                }
                else if(rs.getString("departamento") != null){
                    tarefa = new TarefaTrabalho(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("departamento"), rs.getDate("prazorevisao"));
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