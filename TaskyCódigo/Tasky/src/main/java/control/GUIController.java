/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import view.*;
/**
 *
 * @author Fabio
 */
public class GUIController {
    EquipeSelecionarUsuarioGUI equipeSelecionarUsuarioGUI;
    EquipeView equipeView;
    InicioGUI inicioGUI;
    LoginView loginView;
    PerfilGUI perfilGUI;
    PerfilView perfilView;
    PrincipalGUI principalGUI;
    ProjetoAtribuirTarefaView projetoAtribuirTarefaView;
    ProjetoEditorView projetoEditorView;
    ProjetoGUI projetoGUI;
    ProjetoManagerGUI projetoManagerGUI;
    ProjetoView projetoView;
    ProjetoViewerGUI projetoViewerGUI;
    TarefaDetalhesGUI tarefaDetalhesGUI;
    TarefaEditorView tarefaEditorView;
    TarefaGUI tarefaGUI;
    TarefaProjetoGUI tarefaProjetoGUI;
    TarefaView tarefaView;
    UsuarioView usuarioView;

    Integer idProjeto;
    Integer idEquipe;
    Integer idUsuario;
    Integer idTarefa;
    Usuario usuarioSessao;
    
    List<Usuario> equipeMembros;
    
    
    public GUIController(){
        inicioGUI = new InicioGUI(this);
        tarefaGUI = new TarefaGUI(this);;
        projetoGUI = new ProjetoGUI(this);
        principalGUI = new PrincipalGUI(this);
        perfilGUI = new PerfilGUI(this);
        loginView = new LoginView(this);
        
        inicioGUI.setVisible(true);
    }
    
    public void mostrarLogin(){
        inicioGUI.setVisible(false);
        tarefaGUI.setVisible(false);
        projetoGUI.setVisible(false);
        principalGUI.setVisible(false);
        perfilGUI.setVisible(false);
        loginView.setVisible(true);
    }
    
    public void mostrarPrincipalGUILogin(){
        inicioGUI.setVisible(false);
        tarefaGUI.setVisible(false);
        projetoGUI.setVisible(false);
        principalGUI.setVisible(true);
        perfilGUI.setVisible(false);
        loginView.setVisible(false);
        
        tarefaGUI.setUsuarioSessao(usuarioSessao);
        projetoGUI.setUsuarioSessao(usuarioSessao);
        principalGUI.setUsuarioSessao(usuarioSessao);
        perfilGUI.setUsuarioSessao(usuarioSessao);
        
        principalGUI.initRotUsuario();
        
    }
    
    public void mostrarPerfilGUIPrincipal(){

        perfilGUI.setVisible(true);
 
        
        perfilGUI.mostrarDadosPerfil(usuarioSessao.getPerfilUsuario());
    }
    
    public void mostrarTarefaView(){
        TarefaView tarefaView = new TarefaView(this);
        tarefaView.setUsuarioSessao(usuarioSessao);
        tarefaView.setVisible(true);
    }
    
    public void mostrarTarefaDetalhesGUI(Integer idTarefa){
        TarefaDetalhesGUI tarefaDetalhesGUI = new TarefaDetalhesGUI(this, idTarefa);
        tarefaDetalhesGUI.setVisible(true);
    }
    
    public void mostrarTarefaGUI(){
        inicioGUI.setVisible(false);
        tarefaGUI.setVisible(true);
        projetoGUI.setVisible(false);
        principalGUI.setVisible(true);
        perfilGUI.setVisible(false);
        loginView.setVisible(false);
        
        tarefaGUI.atualizar();
    }
    
    public void mostrarProjetoGUI(){
        inicioGUI.setVisible(false);
        tarefaGUI.setVisible(false);
        projetoGUI.setVisible(true);
        principalGUI.setVisible(true);
        perfilGUI.setVisible(false);
        loginView.setVisible(false);
        
        projetoGUI.atualizar();
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
    
    public void mostrarProjetoAtribuirTarefaView(Integer idProjeto){
        this.idProjeto = null;
        ProjetoAtribuirTarefaView projetoAtribuirTarefaView = new ProjetoAtribuirTarefaView(this, idProjeto);
        projetoAtribuirTarefaView.setVisible(true);
        
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        projetoAtribuirTarefaView.setUsuarioSessao(usuarioDAO.consultarUsuario(2));
    }
    

    
    public void mostrarProjetoView(){
        //temp test code
        

        ProjetoView projetoView = new ProjetoView(this);
        projetoView.setUsuarioSessao(usuarioSessao);
        projetoView.setVisible(true);
    }
    
    public void mostrarPerfilView(){

        PerfilView perfilView = new PerfilView(this);
        perfilView.setUsuarioSessao(usuarioSessao);
        perfilView.setVisible(true);
    }
    
    public void mostrarEquipeView(int idProjeto){
        //temp test code
        

        EquipeView equipeView = new EquipeView(this, idProjeto);
        equipeView.setUsuarioSessao(usuarioSessao);
        equipeView.setVisible(true);
    }
    
    public void mostrarEquipeSelecionarUsuarioGUI(Integer idProjeto){
        EquipeSelecionarUsuarioGUI equipeSelecionarUsuarioGUI = new EquipeSelecionarUsuarioGUI(this, idProjeto);
        equipeSelecionarUsuarioGUI.setVisible(true);
    }
    
    public void mostrarProjetoManagerGUI(Integer idProjeto){
        ProjetoManagerGUI projetoManagerGUI = new ProjetoManagerGUI(this, idProjeto);
        projetoManagerGUI.setVisible(true);
        projetoManagerGUI.setUsuarioSessao(usuarioSessao);
        
    }
    
    public void mostrarProjetoViewerGUI(Integer idProjeto){
        ProjetoViewerGUI projetoViewerGUI = new ProjetoViewerGUI(this, idProjeto);
        projetoViewerGUI.setVisible(true);
        projetoViewerGUI.setUsuarioSessao(usuarioSessao);
    
    }
    
    public void mostrarUsuarioView(){
        UsuarioView usuarioView = new UsuarioView(this);
        usuarioView.setVisible(true);
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

    public List<Usuario> getEquipeMembros() {
        return equipeMembros;
    }

    public void setEquipeMembros(List<Usuario> equipeMembros) {
        this.equipeMembros = equipeMembros;
    }

    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public void setUsuarioSessao(Usuario usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
