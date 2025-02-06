/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.GUIController;
import model.Usuario;

/**
 *
 * @author Fabio
 */
public class PrincipalGUI extends javax.swing.JFrame {
    private Usuario usuarioSessao;
    GUIController guiController;
    
    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public void setUsuarioSessao(Usuario usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }
    
    /**
     * Creates new form PrincipalGUI
     */
    public PrincipalGUI(GUIController guiController) {
        this.usuarioSessao = new Usuario();
        this.guiController = guiController;
        
        initComponents();
        
        initRotUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCalendario = new javax.swing.JButton();
        btUsuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btProjetos = new javax.swing.JButton();
        btTarefas = new javax.swing.JButton();
        pnlUsuario = new javax.swing.JPanel();
        pnlPerfil = new javax.swing.JPanel();
        rotUsuario = new javax.swing.JLabel();

        btCalendario.setText("Calendário");
        btCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalendarioActionPerformed(evt);
            }
        });

        btUsuarios.setText("Usuarios");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tasky");
        jLabel1.setToolTipText("");

        btProjetos.setText("Projetos");
        btProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjetosActionPerformed(evt);
            }
        });

        btTarefas.setText("Tarefas");
        btTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTarefasActionPerformed(evt);
            }
        });

        pnlUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlUsuarioMouseClicked(evt);
            }
        });

        pnlPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlPerfilLayout = new javax.swing.GroupLayout(pnlPerfil);
        pnlPerfil.setLayout(pnlPerfilLayout);
        pnlPerfilLayout.setHorizontalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        pnlPerfilLayout.setVerticalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        rotUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotUsuario.setText("Perfil");

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotUsuario)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotUsuario)
                    .addComponent(pnlPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(578, 578, 578)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(574, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(btProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProjetosActionPerformed
        guiController.mostrarProjetoGUI();
    }//GEN-LAST:event_btProjetosActionPerformed

    private void btCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCalendarioActionPerformed

    private void btTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTarefasActionPerformed
        guiController.mostrarTarefaGUI();
    }//GEN-LAST:event_btTarefasActionPerformed

    private void pnlUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUsuarioMouseClicked
        guiController.mostrarPerfilGUIPrincipal();
    }//GEN-LAST:event_pnlUsuarioMouseClicked


    public void initRotUsuario(){
        rotUsuario.setText(usuarioSessao.getNome());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalendario;
    private javax.swing.JButton btProjetos;
    private javax.swing.JButton btTarefas;
    private javax.swing.JButton btUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlPerfil;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JLabel rotUsuario;
    // End of variables declaration//GEN-END:variables
}
