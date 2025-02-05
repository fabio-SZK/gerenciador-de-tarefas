/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.GUIController;
import control.ProjetoCtrl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Tarefa;

/**
 *
 * @author Fabio
 */
public class ProjetoSelecionarTarefaGUI extends javax.swing.JFrame {
    Integer idProjeto;
    Integer idTarefa;
    GUIController guiController;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

    
    
    /**
     * Creates new form TarefaProjetoGUI
     * @param idProjeto
     */
    public ProjetoSelecionarTarefaGUI(GUIController guiController, Integer idProjeto) {
        this.idProjeto = idProjeto;
        this.guiController = guiController;
        
        initComponents();
        
        // Fetch projects from database
        ProjetoCtrl projetoDAO = new ProjetoCtrl();
        List<Tarefa> tarefas = projetoDAO.consultarTarefas(idProjeto);

        // Add each project to the content panel
        for (Tarefa tarefa : tarefas) {
            pnlProjetos.add(createTaskBlock(tarefa));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlScrl = new javax.swing.JScrollPane();
        pnlProjetos = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pnlScrl.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlProjetos.setLayout(new javax.swing.BoxLayout(pnlProjetos, javax.swing.BoxLayout.Y_AXIS));
        pnlScrl.setViewportView(pnlProjetos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlScrl, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pnlScrl, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ProjetoSelecionarTarefaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjetoSelecionarTarefaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjetoSelecionarTarefaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjetoSelecionarTarefaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjetoSelecionarTarefaGUI(new GUIController(), 2).setVisible(true);
            }
        });
    }

    private JPanel createTaskBlock(Tarefa tarefa) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(350, 100));
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel rotDescricao = new JLabel("<html><i>" + tarefa.getDescricao() + "</i></html>");
        rotDescricao.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel rotPrioridade = new JLabel("<html><i> Prioridade: " + tarefa.getPrioridade() + "</i></html>");
        rotPrioridade.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JLabel rotPrazo = new JLabel("<html><i> Prazo: " + tarefa.getPrazoEntrega().toString() + "</i></html>");
        rotPrioridade.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton btDetalhes = new JButton("Selecionar");
        btDetalhes.addActionListener(e -> selecionarTarefa(tarefa.getIdTarefa())); // selecionar e retornar pro controlador

        JPanel pnlTexto = new JPanel(new GridLayout(2, 2));
        pnlTexto.setBackground(Color.WHITE);
        pnlTexto.add(rotDescricao);
        pnlTexto.add(rotPrioridade);
        pnlTexto.add(rotPrazo);

        panel.add(pnlTexto, BorderLayout.CENTER);
        panel.add(btDetalhes, BorderLayout.EAST);

        return panel;
    }
    
    public void selecionarTarefa(int idTarefa){
        this.idTarefa = idTarefa;
        guiController.setIdTarefa(idTarefa);
        dispose();
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel pnlProjetos;
    private javax.swing.JScrollPane pnlScrl;
    // End of variables declaration//GEN-END:variables
}
