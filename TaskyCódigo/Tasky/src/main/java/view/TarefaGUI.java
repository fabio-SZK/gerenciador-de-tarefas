/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.GUIController;
import control.UsuarioCtrl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Tarefa;
import model.Usuario;

/**
 *
 * @author Fabio
 */
public class TarefaGUI extends javax.swing.JFrame {
    private Usuario usuarioSessao;
    GUIController guiController;
    
    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public void setUsuarioSessao(Usuario usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }
    
    /**
     * Creates new form TarefaGUI
     */
    public TarefaGUI(GUIController guiController) {
        this.guiController = guiController;
        this.usuarioSessao = new Usuario();
        initComponents();
        
        // Fetch projects from database
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        List<Tarefa> tarefas = usuarioDAO.consultarTarefas(usuarioSessao.getIdUsuario());
        try{
            usuarioDAO.getConexao().getConn().close();
        }
        catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,
            sqle.getMessage(),
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        }
        
        // Add each project to the content panel
        for (Tarefa tarefa : tarefas) {
            pnlTarefas.add(createTaskBlock(tarefa));
        }
        
        pnlTarefas.revalidate();
        pnlTarefas.repaint();
    }

    private JPanel createTaskBlock(Tarefa tarefa) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(550, 100));
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel rotDescricao = new JLabel("<html><i>" + tarefa.getDescricao() + "</i></html>");
        rotDescricao.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel rotPrioridade = new JLabel("<html><i> Prioridade: " + tarefa.getPrioridade() + "</i></html>");
        rotPrioridade.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JLabel rotPrazo = new JLabel("<html><i> Prazo: " + tarefa.getPrazoEntrega().toString() + "</i></html>");
        rotPrioridade.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton btDetalhes = new JButton("Detalhes");
        btDetalhes.addActionListener(e -> guiController.mostrarTarefaDetalhesGUI(tarefa.getIdTarefa()));

        JPanel pnlTexto = new JPanel(new GridLayout(2, 2));
        pnlTexto.setBackground(Color.WHITE);
        pnlTexto.add(rotDescricao);
        pnlTexto.add(rotPrioridade);
        pnlTexto.add(rotPrazo);

        panel.add(pnlTexto, BorderLayout.CENTER);
        panel.add(btDetalhes, BorderLayout.EAST);

        return panel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pnlScrlLista = new javax.swing.JScrollPane();
        pnlTarefas = new javax.swing.JPanel();
        btAtualizar = new javax.swing.JButton();
        rotTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jButton3.setText("Remover Tarefa...");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("Adicionar Tarefa...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pnlScrlLista.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pnlScrlLista.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlTarefas.setLayout(new javax.swing.BoxLayout(pnlTarefas, javax.swing.BoxLayout.Y_AXIS));
        pnlScrlLista.setViewportView(pnlTarefas);

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        rotTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        rotTitulo.setText("Tasky");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(rotTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 325, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAtualizar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(pnlScrlLista, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rotTitulo)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(pnlScrlLista, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addComponent(btAtualizar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guiController.mostrarTarefaView();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btAtualizarActionPerformed

    public void atualizar(){
        pnlTarefas.removeAll();
        pnlTarefas.revalidate();
        pnlTarefas.repaint();
        
        UsuarioCtrl usuarioDAO = new UsuarioCtrl();
        List<Tarefa> tarefas = usuarioDAO.consultarTarefas(usuarioSessao.getIdUsuario());
        
        // Add each project to the content panel
        for (Tarefa tarefa : tarefas) {
            pnlTarefas.add(createTaskBlock(tarefa));
        }
        
        try{
            usuarioDAO.getConexao().getConn().close();
        }
        catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,
            sqle.getMessage(),
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        }
        
        pnlTarefas.revalidate();
        pnlTarefas.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane pnlScrlLista;
    private javax.swing.JPanel pnlTarefas;
    private javax.swing.JLabel rotTitulo;
    // End of variables declaration//GEN-END:variables
}
