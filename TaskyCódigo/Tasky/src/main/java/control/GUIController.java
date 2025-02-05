/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.*;
/**
 *
 * @author Fabio
 */
public class GUIController {
    LoginView loginGUI;
    PrincipalGUI principalGUI;
    PerfilGUI perfilGUI;
    Integer idProjeto;
    Integer idEquipe;
    Integer idUsuario;
    Integer idTarefa;
    
    
    public GUIController(){
        
    }
    
    public void mostrarTarefaProjetoGUI(Integer idUsuario){
        this.idProjeto = null;
        TarefaProjetoGUI tarefaProjetoGUI = new TarefaProjetoGUI(this, idUsuario);
        tarefaProjetoGUI.setVisible(true);
        
    }
    
    public void mostrarProjetoSelecionarEquipeGUI(Integer idProjeto){
        this.idEquipe = null;
        ProjetoSelecionarEquipeGUI projetoSelecionarEquipeGUI = new ProjetoSelecionarEquipeGUI(this, idProjeto);
        projetoSelecionarEquipeGUI.setVisible(true);
    }
    
    
    
    public void mostrarProjetoSelecionarUsuarioGUI(Integer idProjeto){
        this.idUsuario = null;
        ProjetoSelecionarUsuarioGUI projetoSelecionarUsuarioGUI = new ProjetoSelecionarUsuarioGUI(this, idProjeto);
        projetoSelecionarUsuarioGUI.setVisible(true);
    }
    
    public void mostrarProjetoSelecionarTarefaGUI(Integer idProjeto){
        this.idProjeto = null;
        ProjetoSelecionarTarefaGUI projetoSelecionarTarefaGUI = new ProjetoSelecionarTarefaGUI(this, idProjeto);
        projetoSelecionarTarefaGUI.setVisible(true);
    }
    
    public void mostrarTarefaView(){
        // temp test code
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        TarefaView tarefaView = new TarefaView(this);
        tarefaView.setUsuarioSessao(usuarioDAO.consultarUsuario(2));
        tarefaView.setVisible(true);
    }
    
    public void mostrarProjetoView(){
        //temp test code
        
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        ProjetoView projetoView = new ProjetoView(this);
        projetoView.setUsuarioSessao(usuarioDAO.consultarUsuario(2));
        projetoView.setVisible(true);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
