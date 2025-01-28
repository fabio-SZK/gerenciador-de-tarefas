/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import model.*;
import view.*;
import control.*;
/**
 *
 * @author Fabio
 */
public class CRUDTest {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(2, "steve", "minecraft123", "stevecraft@gmail.com");
        
        Perfil perfil = new Perfil();
        
        perfil.setNome("Steve Minecraft");
        perfil.setDescricao("Eu sou steve minecraft!!!!!!");
        perfil.setFuncao("minecrafter");
        
        PerfilCtrl perfilDao = new PerfilCtrl();
        
        perfilDao.atualizar(usuario, perfil);
        
        Perfil perfilViewerTest = perfilDao.selecionar(usuario);
        
        PerfilGUI perfilGUI = new PerfilGUI();
        
        perfilGUI.setVisible(true);
        perfilGUI.mostrarDadosPerfil(perfilViewerTest);
    }
}
