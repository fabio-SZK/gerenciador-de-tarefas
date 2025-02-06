package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Equipe;
import model.Projeto;
import model.Tarefa;
import model.TarefaAcademica;
import model.TarefaPessoal;
import model.TarefaTrabalho;
import model.Usuario;

public class EquipeCtrl{
    
    private ConexaoSQL conexao;

    public EquipeCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }

    public void adicionar(Equipe equipe){
        String sql = "INSERT INTO equipe (usuarioliderid, areaatuacao, descricao, funcao, idprojeto) VALUES (?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO equipemembro (idusuario, idequipe) VALUES (?, ?)";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, equipe.getLiderEquipe().getIdUsuario());
            pstmt.setString(2, equipe.getAreaAtuacao());
            pstmt.setString(3, equipe.getDescricao());
            pstmt.setString(4, equipe.getFuncao());
            pstmt.setInt(5, equipe.getProjeto().getIdProjeto());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                PreparedStatement pstmt2 = conexao.getConn().prepareStatement(sql2);
                Integer idEquipe = rs.getInt(1);
                
                List<Usuario> usuarios = equipe.getMembros();
                
                for (Usuario u : usuarios) {
                    pstmt2.setInt(1, u.getIdUsuario());
                    pstmt2.setInt(2, idEquipe);
                    
                    pstmt2.executeUpdate();
                }
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void remover(Integer idEquipe){
        String sql = "DELETE FROM equipe WHERE idequipe = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            pstmt.setInt(1, idEquipe);
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public ResultSet consultar(Projeto projeto){
        String sql = "SELECT idequipe, usuarioliderid, areaatuacao, descricao, funcao, idprojeto FROM equipe WHERE idprojeto = ?";
        
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
        String sql = "UPDATE equipe SET usuarioliderid = ?, areaatuacao = ?, descricao = ?, funcao = ?, idprojeto = ? WHERE idequipe = ?";
        
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
    
    public Equipe consultarEquipe(int idEquipe){
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        String sql = "SELECT idequipe, usuarioliderid, areaatuacao, descricao, funcao, idprojeto FROM equipe WHERE idequipe = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, idEquipe);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Equipe e = new Equipe(
                        rs.getInt("idequipe"),
                        usuarioDAO.consultarUsuario(rs.getInt("usuarioliderid")),
                        rs.getString("areaatuacao"),
                        rs.getString("descricao"),
                        rs.getString("funcao"),
                        projetoDAO.consultarProjeto(rs.getInt("idprojeto"))
                );
                

                usuarioDAO.getConexao().getConn().close(); // 
                projetoDAO.getConexao().getConn().close(); //
                
                return e;
            }
            
            
            usuarioDAO.getConexao().getConn().close(); // 
            projetoDAO.getConexao().getConn().close(); //
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
 
    }
    
    public List<Usuario> consultarMembros(int idEquipe){
        List<Usuario> membros = new ArrayList<>();
        PerfilCtrl perfilDAO = new PerfilCtrl();
        // testar depois
        String sql = """
            SELECT \"idUsuario\", nome, senha, email
            FROM usuario 
            JOIN equipemembro 
            ON usuario.\"idUsuario\" = equipemembro.idusuario  
            WHERE equipemembro.idequipe = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, idEquipe);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("email"),
                        perfilDAO.selecionar(rs.getInt("idUsuario"))
                );
                
                membros.add(u);
            }
            
            perfilDAO.getConexao().getConn().close(); //

            
            return membros;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public List<Tarefa> consultarTarefas(int idEquipe){
        List<Tarefa> tarefas = new ArrayList<>();
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        
        String sql = """
            SELECT t.idtarefa, t.prazoentrega, t.descricao, t.prioridade, t.datacriacao, t.idusuario, t.idequipe, t.idprojeto, ta.materia, ta.professor, ta.nota, tp.recorrencia, tp.local, tt.departamento, tt.prazorevisao
            FROM tarefa t
            LEFT JOIN tarefaacademica ta ON ta.idtarefa = t.idtarefa
            LEFT JOIN tarefapessoal tp ON tp.idtarefa = t.idtarefa
            LEFT JOIN tarefatrabalho tt ON tt.idtarefa = t.idtarefa
            WHERE t.idequipe = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, idEquipe);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int idTarefa = rs.getInt("idtarefa");
                Date prazoentrega = rs.getDate("prazoentrega");
                String descricao = rs.getString("descricao");
                String prioridade = rs.getString("prioridade");
                Date datacriacao = rs.getDate("datacriacao");
                Usuario tUsuario = usuarioDAO.consultarUsuario(rs.getInt("idusuario"));
                Equipe equipe = consultarEquipe(rs.getInt("idequipe"));
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
                
                tarefas.add(tarefa);
            }
            

            usuarioDAO.getConexao().getConn().close(); // 
            projetoDAO.getConexao().getConn().close(); //
            
            return tarefas;
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