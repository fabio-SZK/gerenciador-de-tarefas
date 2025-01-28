/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.PerfilCtrl;
import model.Perfil;
import model.Usuario;

/**
 *
 * @author Fabio
 */
public class PerfilGUI extends javax.swing.JFrame {

    /**
     * Creates new form PerfilGUI
     */
    public PerfilGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rotTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PnlPerfil = new javax.swing.JPanel();
        rotNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rotDescricao = new javax.swing.JTextArea();
        rotFuncao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        rotTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        rotTitulo.setText("Tasky");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PnlPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PnlPerfilLayout = new javax.swing.GroupLayout(PnlPerfil);
        PnlPerfil.setLayout(PnlPerfilLayout);
        PnlPerfilLayout.setHorizontalGroup(
            PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        PnlPerfilLayout.setVerticalGroup(
            PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        rotNome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        rotNome.setText("jLabel2");

        rotDescricao.setEditable(false);
        rotDescricao.setBackground(new java.awt.Color(242, 242, 242));
        rotDescricao.setColumns(20);
        rotDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rotDescricao.setLineWrap(true);
        rotDescricao.setRows(5);
        rotDescricao.setText("sadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        rotDescricao.setWrapStyleWord(true);
        rotDescricao.setBorder(null);
        rotDescricao.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        rotDescricao.setEnabled(false);
        rotDescricao.setOpaque(false);
        jScrollPane1.setViewportView(rotDescricao);

        rotFuncao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rotFuncao.setText("Função: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotFuncao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PnlPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rotNome)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(rotTitulo)))
                .addContainerGap(568, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(rotTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotNome)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addComponent(rotFuncao)
                .addGap(317, 317, 317))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarDadosPerfil(Perfil perfil){
        rotNome.setText(perfil.getNome());
        rotDescricao.setText(perfil.getDescricao());
        rotFuncao.setText("Função: "+perfil.getFuncao());
    }
    
    /**
     * @param args the command line arguments
     */
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea rotDescricao;
    private javax.swing.JLabel rotFuncao;
    private javax.swing.JLabel rotNome;
    private javax.swing.JLabel rotTitulo;
    // End of variables declaration//GEN-END:variables
}
