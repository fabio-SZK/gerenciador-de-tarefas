/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import control.GUIController;
import control.UsuarioCtrl;
/**
 *
 * @author Fabio
 */
public class CRUDTest {
    public static void main(String[] args) {

        /*
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        
        PerfilCtrl perfilDao = new PerfilCtrl();
        

        
        Perfil perfilViewerTest = perfilDao.selecionar(1);
        
        PerfilGUI perfilGUI = new PerfilGUI();
        
        
        perfilGUI.setUsuarioSessao(usuarioDAO.consultarUsuario(2));
        
        perfilGUI.setVisible(true);
        perfilGUI.mostrarDadosPerfil(perfilViewerTest);
        */
        
        /*
        JOptionPane.showMessageDialog(null,
    "Eggs are not supposed to be green.",
    "Inane error",
    JOptionPane.ERROR_MESSAGE);
        */
        
        /* TarefaView test
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        GUIController guiController = new GUIController();
        //tarefaView.setUsuarioSessao(usuarioDAO.consultarUsuario(2));
        //tarefaView.setVisible(true);
        
        guiController.mostrarTarefaView();
        */
        
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        GUIController guiController = new GUIController();
        
        guiController.mostrarProjetoView();
    }
}
