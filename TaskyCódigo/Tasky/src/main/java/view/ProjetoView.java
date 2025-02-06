/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.DateConverter;
import control.GUIController;
import control.ProjetoCtrl;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Projeto;
import model.Usuario;

/**
 *
 * @author Fabio
 */
public class ProjetoView extends javax.swing.JFrame {
    private Usuario usuarioSessao;
    private GUIController guiController;

    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public void setUsuarioSessao(Usuario usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }
    
    
    /**
     * Creates new form ProjetoView
     * @param guiController
     */
    public ProjetoView(GUIController guiController) {
        this.guiController = guiController;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        rotNome = new javax.swing.JLabel();
        rotDescricao = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rotPrazo = new javax.swing.JLabel();
        rotObjetivo = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        cxNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cxDescricao = new javax.swing.JTextArea();
        cxPrazo = new javax.swing.JTextField();
        cxObjetivo = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rotNome.setText("Nome do projeto:");

        rotDescricao.setText("Descrição:");

        rotPrazo.setText("Data limite:");

        rotObjetivo.setText("Objetivo:");

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        cxDescricao.setColumns(20);
        cxDescricao.setRows(5);
        jScrollPane2.setViewportView(cxDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btLimpar)
                                .addGap(18, 18, 18)
                                .addComponent(btEnviar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rotNome)
                                    .addComponent(rotDescricao)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cxNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotPrazo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotObjetivo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxObjetivo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxPrazo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 210, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rotNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEnviar)
                            .addComponent(btLimpar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rotPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rotObjetivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        LocalDate localDate = LocalDate.now();
        Date dataCriacao = Date.valueOf(localDate);
        Projeto projeto;
        // adicionar projeto pelo controller depois

        try{
            String nome = cxNome.getText();
            String descricao = cxDescricao.getText();
            Date prazoEntrega = DateConverter.convertToSqlDate(cxPrazo.getText());
            String objetivo = cxObjetivo.getText();
            projeto = new Projeto(null, nome, descricao, dataCriacao, prazoEntrega, objetivo);

            ProjetoCtrl projetoDAO = new ProjetoCtrl();
            projetoDAO.adicionar(usuarioSessao, projeto);
            projetoDAO.getConexao().getConn().close();
        }
        catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,
                "Formato de valor inválido",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null,
                "Formato de valor inválido",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btEnviarActionPerformed


    
    private void limpar() {
        cxNome.setText("");
        cxDescricao.setText("");
        cxPrazo.setText("");
        cxObjetivo.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JTextArea cxDescricao;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxObjetivo;
    private javax.swing.JTextField cxPrazo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel rotDescricao;
    private javax.swing.JLabel rotNome;
    private javax.swing.JLabel rotObjetivo;
    private javax.swing.JLabel rotPrazo;
    // End of variables declaration//GEN-END:variables
}
