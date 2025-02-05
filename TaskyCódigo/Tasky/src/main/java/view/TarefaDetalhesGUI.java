/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.TarefaCtrl;
import model.Tarefa;
import model.TarefaAcademica;
import model.TarefaPessoal;
import model.TarefaTrabalho;

/**
 *
 * @author Fabio
 */
public class TarefaDetalhesGUI extends javax.swing.JFrame {
    Tarefa tarefa;
    /**
     * Creates new form TarefaDetalhesGUI
     * @param tarefa
     * @param tipo
     */
    public TarefaDetalhesGUI(int idTarefa) {
        TarefaCtrl tarefaDAO = new TarefaCtrl();
        this.tarefa = tarefaDAO.consultarTarefa(idTarefa);

        
        initComponents();
        preencherDadosTarefa();
        if(tarefa instanceof TarefaPessoal){
            TarefaPessoal tarefaPessoal = (TarefaPessoal) tarefa;
            mostrarTarefaPessoal(tarefaPessoal.getRecorrencia(), tarefaPessoal.getLocal());
        }
        
        if(tarefa instanceof TarefaAcademica){
            TarefaAcademica tarefaAcademica = (TarefaAcademica) tarefa;
            mostrarTarefaAcademica(tarefaAcademica.getMateria(), tarefaAcademica.getProfessor(), tarefaAcademica.getNota());
        }
        
        if(tarefa instanceof TarefaTrabalho){
            TarefaTrabalho tarefaTrabalho = (TarefaTrabalho) tarefa;
            mostrarTarefaTrabalho(tarefaTrabalho.getDepartamento(), tarefaTrabalho.getPrazoRevisao().toString());
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

        rotLocal = new javax.swing.JLabel();
        rotRecorrencia = new javax.swing.JLabel();
        rotDepartamento = new javax.swing.JLabel();
        rotPrazoRevisao = new javax.swing.JLabel();
        rotNota = new javax.swing.JLabel();
        rotMateria = new javax.swing.JLabel();
        rotProfessor = new javax.swing.JLabel();
        PnlPrincipal = new javax.swing.JPanel();
        rotTarefa = new javax.swing.JLabel();
        rotDesc = new javax.swing.JLabel();
        rotDescTexto = new javax.swing.JLabel();
        rotDataCriacao = new javax.swing.JLabel();
        rotPrazoEntrega = new javax.swing.JLabel();
        rotPrioridade = new javax.swing.JLabel();
        rotUsuario = new javax.swing.JLabel();
        rotProjeto = new javax.swing.JLabel();
        rotEquipe = new javax.swing.JLabel();
        rotTipo = new javax.swing.JLabel();
        pnlTipo = new javax.swing.JPanel();

        rotLocal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotLocal.setText("Local:");

        rotRecorrencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotRecorrencia.setText("Recorrência:");

        rotDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotDepartamento.setText("Departamento:");

        rotPrazoRevisao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotPrazoRevisao.setText("Prazo de revisão:");

        rotNota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotNota.setText("Nota:");

        rotMateria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotMateria.setText("Materia:");

        rotProfessor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotProfessor.setText("Professor:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rotTarefa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rotTarefa.setText("Tarefa:");

        rotDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotDesc.setText("Descrição:");

        rotDescTexto.setText("jLabel3");
        rotDescTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rotDataCriacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotDataCriacao.setText("Data de criação:");

        rotPrazoEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotPrazoEntrega.setText("Prazo:");

        rotPrioridade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotPrioridade.setText("Prioridade:");

        rotUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotUsuario.setText("Usuario:");

        rotProjeto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotProjeto.setText("Projeto:");

        rotEquipe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotEquipe.setText("Equipe:");

        rotTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotTipo.setText("Tipo: Genérico");

        pnlTipo.setLayout(new java.awt.GridLayout(2, 2));

        javax.swing.GroupLayout PnlPrincipalLayout = new javax.swing.GroupLayout(PnlPrincipal);
        PnlPrincipal.setLayout(PnlPrincipalLayout);
        PnlPrincipalLayout.setHorizontalGroup(
            PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlPrincipalLayout.createSequentialGroup()
                        .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotTipo)
                            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                                .addComponent(rotPrioridade)
                                .addGap(118, 118, 118)
                                .addComponent(rotProjeto))
                            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rotDataCriacao)
                                    .addComponent(rotPrazoEntrega))
                                .addGap(86, 86, 86)
                                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rotEquipe)
                                    .addComponent(rotUsuario))))
                        .addContainerGap(530, Short.MAX_VALUE))
                    .addGroup(PnlPrincipalLayout.createSequentialGroup()
                        .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rotDescTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                            .addComponent(rotTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rotDesc)
                            .addComponent(pnlTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PnlPrincipalLayout.setVerticalGroup(
            PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(rotTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotDescTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotPrioridade)
                    .addComponent(rotProjeto))
                .addGap(18, 18, 18)
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotDataCriacao)
                    .addComponent(rotUsuario))
                .addGap(18, 18, 18)
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotPrazoEntrega)
                    .addComponent(rotEquipe))
                .addGap(41, 41, 41)
                .addComponent(rotTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TarefaDetalhesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarefaDetalhesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarefaDetalhesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarefaDetalhesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarefaDetalhesGUI(12).setVisible(true);
            }
        });
    }

    public void preencherDadosTarefa(){
        rotDescTexto.setText("<html><i>" + tarefa.getDescricao() + "</i></html>");
        rotPrioridade.setText("Prioridade: " + tarefa.getPrioridade());
        rotDataCriacao.setText("DataCriacao: " + tarefa.getDataCriacao());
        rotPrazoEntrega.setText("PrazoEntrega: " + tarefa.getPrazoEntrega());
        
        if(tarefa.getProjeto().getIdProjeto() == 0){
            rotProjeto.setText("Projeto: Nenhum");
        }
        else{
            rotProjeto.setText("Projeto: " + tarefa.getProjeto().getNome());
        }
        
        rotUsuario.setText("Usuario: " + tarefa.getUsuario().getNome());
        
        if(tarefa.getEquipe().getIdEquipe() == 0){
            rotEquipe.setText("Equipe: Nenhum");
        }
        else{
            rotEquipe.setText("Equipe: Sim");
        }
    }
    
    public void mostrarTarefaPessoal(String recorrencia, String local){
        pnlTipo.add(rotRecorrencia);
        pnlTipo.add(rotLocal);
        
        pnlTipo.revalidate();
        pnlTipo.repaint();
        
        rotTipo.setText("Tipo: Pessoal");
        rotRecorrencia.setText("Recorrência: " + recorrencia);
        rotLocal.setText("Local: " + local);
        
    }
    
    public void mostrarTarefaAcademica(String materia, String professor, double nota){
        pnlTipo.add(rotMateria);
        pnlTipo.add(rotProfessor);
        pnlTipo.add(rotNota);
        
        pnlTipo.revalidate();
        pnlTipo.repaint();
        
        rotTipo.setText("Tipo: Acadêmica");
        rotMateria.setText("Matéria: " + materia);
        rotProfessor.setText("Professor: " + professor);
        rotNota.setText("Nota: " + nota);
    }
    
    public void mostrarTarefaTrabalho(String departamento, String prazoRevisao){
        pnlTipo.add(rotDepartamento);
        pnlTipo.add(rotPrazoRevisao);
        
        pnlTipo.revalidate();
        pnlTipo.repaint();
        
        rotTipo.setText("Tipo: Trabalho");
        rotDepartamento.setText("Departamento: " + departamento);
        rotPrazoRevisao.setText("Prazo de revisão: " + prazoRevisao);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlPrincipal;
    private javax.swing.JPanel pnlTipo;
    private javax.swing.JLabel rotDataCriacao;
    private javax.swing.JLabel rotDepartamento;
    private javax.swing.JLabel rotDesc;
    private javax.swing.JLabel rotDescTexto;
    private javax.swing.JLabel rotEquipe;
    private javax.swing.JLabel rotLocal;
    private javax.swing.JLabel rotMateria;
    private javax.swing.JLabel rotNota;
    private javax.swing.JLabel rotPrazoEntrega;
    private javax.swing.JLabel rotPrazoRevisao;
    private javax.swing.JLabel rotPrioridade;
    private javax.swing.JLabel rotProfessor;
    private javax.swing.JLabel rotProjeto;
    private javax.swing.JLabel rotRecorrencia;
    private javax.swing.JLabel rotTarefa;
    private javax.swing.JLabel rotTipo;
    private javax.swing.JLabel rotUsuario;
    // End of variables declaration//GEN-END:variables
}
