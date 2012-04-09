/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.LoginControl;
import Entity.Actual_User;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    private LoginControl lc = new LoginControl();
    Principal principal = Actual_User.getInstance().getPrincipal();
    
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        sendB = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        newCustomerB = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(362, 258));

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        userNameTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameTFKeyPressed(evt);
            }
        });

        passwordTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTFKeyPressed(evt);
            }
        });

        sendB.setText("Enviar");
        sendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("CAJERO AUTOMÁTICO ");

        newCustomerB.setText("Nuevo Cliente");
        newCustomerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomerBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(newCustomerB)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sendB))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(64, 64, 64)
                            .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendB)
                    .addComponent(newCustomerB))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBActionPerformed
        String username = userNameTF.getText();
        String password = String.valueOf(passwordTF.getPassword());
        try{
            boolean res = lc.login(username, password);
            if(res){
                principal.welcome();
            }
            else{
                JOptionPane.showMessageDialog(this, "usuario o contraseña incorrecta", "Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_sendBActionPerformed

    private void newCustomerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCustomerBActionPerformed
        // TODO add your handling code here:
        principal.newCustomer();
    }//GEN-LAST:event_newCustomerBActionPerformed

    private void userNameTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTFKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            passwordTF.requestFocus();
        }
    }//GEN-LAST:event_userNameTFKeyPressed

    private void passwordTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTFKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            this.sendBActionPerformed(null);
        }
    }//GEN-LAST:event_passwordTFKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton newCustomerB;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JButton sendB;
    private javax.swing.JTextField userNameTF;
    // End of variables declaration//GEN-END:variables
}
