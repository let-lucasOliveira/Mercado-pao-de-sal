/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.mercadopaodesal.ui;

import io.mercadopaodesal.dao.Category;
import io.mercadopaodesal.dao.CategoryDAO;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class CategoryScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CategoryScreen.class.getName());
    
    public CategoryScreen() {
        initComponents();
    }
    
    private void clearForm() {
        name_field.setText(null);
        desc_field.setText(null);
    }
    
    private void addCategory(){
        Category newC = new Category();
        
        newC.setNome(name_field.getText());
        newC.setDescription(desc_field.getText());
        
        CategoryDAO cDAO = new CategoryDAO();
        cDAO.add(newC);
    }

    private void editCategory(){
        Category newC = new Category();
        
        newC.setId(Integer.parseInt(id_field.getText()));
        newC.setNome(name_field.getText());
        newC.setDescription(desc_field.getText());
        
        CategoryDAO cDAO = new CategoryDAO();
        cDAO.update(newC);
        //clearForm();   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        save_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idSrch_field = new javax.swing.JTextField();
        sch_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        id_field = new javax.swing.JTextField();
        clearID_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc_field = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CATEGORIAS");

        jLabel2.setText("Nome");

        jLabel3.setText("Descrição");

        save_btn.setText("Salvar");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        jLabel4.setText("ID");

        sch_btn.setText("Buscar");
        sch_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sch_btnActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        id_field.setEnabled(false);

        clearID_btn.setText("Limpar ID");
        clearID_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearID_btnActionPerformed(evt);
            }
        });

        desc_field.setColumns(20);
        desc_field.setLineWrap(true);
        desc_field.setRows(5);
        desc_field.setWrapStyleWord(true);
        jScrollPane1.setViewportView(desc_field);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idSrch_field, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sch_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save_btn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearID_btn))
                            .addComponent(name_field, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idSrch_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sch_btn))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearID_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save_btn)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        if(id_field.getText().isBlank()){
            addCategory();
        }else{
            editCategory();
        }
        clearForm();
    }//GEN-LAST:event_save_btnActionPerformed

    private void sch_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sch_btnActionPerformed
       clearForm();
       
       int idCategory = Integer.parseInt(idSrch_field.getText());
       CategoryDAO cDAO = new CategoryDAO();
       
       Category c = cDAO.get(idCategory);
       if(c == null) {
        id_field.setText("");
        name_field.setText("");
        desc_field.setText("");
        JOptionPane.showMessageDialog(this,"Categoria não encontrada!");
       }
       else {
           id_field.setText(Integer.toString(c.getId()));
           name_field.setText(c.getNome());
           desc_field.setText(c.getDescription());
       }
    }//GEN-LAST:event_sch_btnActionPerformed

    private void clearID_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearID_btnActionPerformed
        id_field.setText("");
    }//GEN-LAST:event_clearID_btnActionPerformed
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CategoryScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearID_btn;
    private javax.swing.JTextArea desc_field;
    private javax.swing.JTextField idSrch_field;
    private javax.swing.JTextField id_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_field;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton sch_btn;
    // End of variables declaration//GEN-END:variables
}
