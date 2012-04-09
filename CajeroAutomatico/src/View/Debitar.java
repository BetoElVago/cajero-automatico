/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.TransactionControl;
import Entity.Actual_User;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Debitar extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    private TransactionControl control;
    
    public Debitar() {
        initComponents();
        control = new TransactionControl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        montoTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sendB = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(362, 258));

        montoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                montoTFKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("DEBITAR");

        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("* Escriba la cantidad de dinero a debitar");

        jLabel2.setText("Monto");

        sendB.setText("Enviar");
        sendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sendB)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(39, 39, 39)
                                    .addComponent(montoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1)))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(sendB)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBActionPerformed
        try{
            double amount = new Double(montoTF.getText());
            int  result = control.retirement();
            Actual_User.getInstance().setBalanceOnChange(amount);
            if(result == 0){
                JOptionPane.showMessageDialog(this, "El retiro ha sido exitoso",
                        "transacción existosa",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(result == -1){
               JOptionPane.showMessageDialog(this, "El monto a retirar debe ser mínimo de $10000 y máximo de $400000",
                       "Error en la transacción",JOptionPane.WARNING_MESSAGE); 
            }
            else if(result == -2){
                JOptionPane.showMessageDialog(this, "No hay saldo suficiente",
                        "Error la transacción",JOptionPane.WARNING_MESSAGE);
            }
            else if(result == -3){
               JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado mientra se hacía la transacción"
                       ,"Error en la transacicióñ",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado mientra se hacía la transacción"
                       ,"Error en la transacicióñ",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sendBActionPerformed

    private void montoTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoTFKeyTyped
        // TODO add your handling code here:
        char l = evt.getKeyChar();
        if(!Character.isDigit(l)){
            evt.consume();
        }
    }//GEN-LAST:event_montoTFKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField montoTF;
    private javax.swing.JButton sendB;
    // End of variables declaration//GEN-END:variables
}
