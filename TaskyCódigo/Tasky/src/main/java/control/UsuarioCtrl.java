package control;
import model.Usuario;
import java.sql.Statement;
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


public class UsuarioCtrl{
    private ConexaoSQL conexao;

    public UsuarioCtrl(){
        conexao = new ConexaoSQL();
        conexao.conectarBD();
    }
    
    public Usuario registrar(Usuario usuario){
        String sqlQuery = "SELECT * FROM usuario WHERE nome = ?";
        String sql = "INSERT INTO usuario (nome, senha, email) VALUES (?, ?, ?)";
        PerfilCtrl perfilDAO = new PerfilCtrl();
        
        try{

            PreparedStatement pstmtQuery = conexao.getConn().prepareStatement(sqlQuery);
            
            pstmtQuery.setString(1, usuario.getNome());
            
            ResultSet rs = pstmtQuery.executeQuery();
            
            if(!rs.next()){
                PreparedStatement pstmt = conexao.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getSenha());
                pstmt.setString(3, usuario.getEmail());
            
                pstmt.executeUpdate();
                
                ResultSet rs2 = pstmt.getGeneratedKeys();
                
                if(rs2.next()){
                    Integer idUsuario = rs2.getInt("idUsuario");
                    System.out.println(idUsuario);
                    usuario.setIdUsuario(idUsuario);
                    perfilDAO.adicionar(usuario);
                }
                
                     // Adicionar um perfil padrão
                
                perfilDAO.getConexao().getConn().close(); //
                
                return usuario;
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return null; // Registração falhada
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
                      
                Usuario login = new Usuario();
                login.setIdUsuario(idUsuario);
                login.setNome(usuario);
                login.setSenha(senha);
                login.setEmail(email);
                
                System.out.println("Login sucesso");
                return login;
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            // falha na autenticação
        }
        System.out.println("Login falha");
        return null; // Autenticação falhada, usuário ou senha incorreto
    }
    
    public void remover(Usuario usuario){
        String sql = "DELETE FROM usuario WHERE \"idUsuario\" = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            pstmt.setInt(1, usuario.getIdUsuario());
            
            pstmt.executeUpdate();
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }

    public List<Projeto> consultarProjetos(int idUsuario){

        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT projeto.idprojeto, nome, descricao, datacriacao, dataultima, objetivo FROM projeto JOIN projetomembro ON projeto.idprojeto = projetomembro.idprojeto WHERE projetomembro.idusuario = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setInt(1, idUsuario);
            
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
                
                projetos.add(p);
            }
            
            return projetos;
        }
        catch(SQLException sqle){
            sqle.getMessage();
        }
        
        return null;
    }
    
    public List<Equipe> consultarEquipes(int idUsuario){

        ProjetoCtrl projetoDAO = new ProjetoCtrl();
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
            
            pstmt.setInt(1, idUsuario);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Equipe e = new Equipe(
                        rs.getInt("idequipe"),
                        consultarUsuario(rs.getInt("usuarioliderid")), 
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
    
    public List<Tarefa> consultarTarefas(Integer idUsuario){
        List<Tarefa> tarefas = new ArrayList<>();
        EquipeCtrl equipeDAO = new EquipeCtrl();
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        
        
        String sql = """
            SELECT t.idtarefa, t.prazoentrega, t.descricao, t.prioridade, t.datacriacao, t.idusuario, t.idequipe, t.idprojeto, ta.materia, ta.professor, ta.nota, tp.recorrencia, tp.local, tt.departamento, tt.prazorevisao
            FROM tarefa t
            LEFT JOIN tarefaacademica ta ON ta.idtarefa = t.idtarefa
            LEFT JOIN tarefapessoal tp ON tp.idtarefa = t.idtarefa
            LEFT JOIN tarefatrabalho tt ON tt.idtarefa = t.idtarefa
            WHERE t.idusuario = ?
        """;
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            
            pstmt.setObject(1, idUsuario, java.sql.Types.INTEGER);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int idTarefa = rs.getInt("idtarefa");
                Date prazoentrega = rs.getDate("prazoentrega");
                String descricao = rs.getString("descricao");
                String prioridade = rs.getString("prioridade");
                Date datacriacao = rs.getDate("datacriacao");
                Usuario tUsuario = consultarUsuario(rs.getInt("idusuario"));
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
                    tarefa = new TarefaTrabalho(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto, rs.getString("departamento"), rs.getDate("prazorevisao"));
                }
                else{
                    tarefa = new Tarefa(idTarefa, prazoentrega, descricao, prioridade, datacriacao, tUsuario, equipe, projeto);
                }
                
                tarefas.add(tarefa);
            }
            
            equipeDAO.getConexao().getConn().close(); //
            projetoDAO.getConexao().getConn().close(); //
            
            return tarefas;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public Usuario consultarUsuario(int idUsuario){
        PerfilCtrl perfilDAO = new PerfilCtrl();
        String sql = "SELECT \"idUsuario\", nome, senha, email FROM usuario WHERE \"idUsuario\" = ?";
        
        try{
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("email"),
                        perfilDAO.selecionar(rs.getInt("idUsuario"))
                );
                
                perfilDAO.getConexao().getConn().close();
                
                return u;
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
        return null;
    }
    
    public List<Usuario> consultar(){
        String sql = "SELECT * FROM perfil";
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
            Statement stmt = conexao.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
                
                usuarios.add(u);
            }
            
            return usuarios;
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