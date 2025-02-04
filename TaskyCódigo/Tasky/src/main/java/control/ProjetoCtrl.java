package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Projeto;
import java.util.Date;
import java.util.List;
import model.Equipe;
import model.Tarefa;
import model.TarefaAcademica;
import model.TarefaPessoal;
import model.TarefaTrabalho;
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
        String sql = "SELECT projeto.idprojeto, nome, descricao, datacriacao, dataultima, objetivo FROM projeto WHERE idprojeto = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, idProjeto);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Projeto p = new Projeto(
                        rs.getInt("idprojeto"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDate("datacriacao"),
                        rs.getDate("dataultima"),
                        rs.getString("objetivo")
                );
                
                return p;
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
        
    }
    
    public List<Usuario> consultarMembros(int idProjeto){
        List<Usuario> membros = new ArrayList<>();
        PerfilCtrl perfilDAO = new PerfilCtrl();
        // testar depois
        String sql = """
            SELECT \"idUsuario\", nome, senha, email
            FROM usuario 
            JOIN projetomembro 
            ON usuario.\"idUsuario\" = projetomembro.idusuario  
            WHERE projetomembro.idprojeto = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, idProjeto);
            
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
            
            return membros;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public List<Usuario> consultarLideres(int idProjeto){
        List<Usuario> lideres = new ArrayList<>();
        PerfilCtrl perfilDAO = new PerfilCtrl();
        // testar depois
        String sql = """
            SELECT \"idUsuario\", nome, senha, email
            FROM usuario 
            JOIN projetolider 
            ON usuario.\"idUsuario\" = projetolider.idusuario  
            WHERE projetolider.idprojeto = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, idProjeto);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("email"),
                        perfilDAO.selecionar(rs.getInt("idUsuario"))
                );
                
                lideres.add(u);
            }
            
            return lideres;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public List<Equipe> consultarEquipes(int idProjeto){
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        List<Equipe> equipes = new ArrayList<>();
        String sql = """
            SELECT equipe.idequipe, usuarioliderid, areaatuacao, descricao, funcao, idprojeto 
            FROM equipe 
            JOIN equipemembro 
            ON equipe.idequipe = equipemembro.idequipe 
            WHERE equipemembro.idusuario = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, idProjeto);
            
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
                
                equipes.add(e);
            }
            
            return equipes;
        }
        catch(SQLException sqle){
            sqle.getMessage();
        }
        
        return null;
    }
    
    public List<Tarefa> consultarTarefas(int idProjeto){
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
            WHERE t.idprojeto = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, idProjeto);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int idTarefa = rs.getInt("idtarefa");
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
                
                tarefas.add(tarefa);
            }
            
            return tarefas;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }

    public List<Projeto> getAllProjects() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

