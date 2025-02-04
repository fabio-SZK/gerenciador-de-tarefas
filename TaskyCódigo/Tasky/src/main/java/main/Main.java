/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import model.Usuario;
import view.*;

/**
 *
 * @author Fabio
 */
public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        while(loginView.getSessao() == null){
            
        }
        
        if(loginView.getSessao() != null){
            Usuario sessao = loginView.getSessao();
            PrincipalGUI principalGUI = new PrincipalGUI(loginView.getSessao());
            principalGUI.setVisible(true);
        }
    }
}
