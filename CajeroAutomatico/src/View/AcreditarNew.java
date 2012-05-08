/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.TransactionControl;
import Controlador.Operacion;
import Entity.Actual_User;
import Entity.Person;
import Modelo.Numero;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class AcreditarNew extends javax.swing.JPanel {
    
    TransactionControl tc = new TransactionControl();

    /**
     * Creates new form Login
     */
    
    private Principal principal =  Actual_User.getInstance().getPrincipal();
    private Person user;
    
    public AcreditarNew(Person user) {
        initComponents();
        this.user = user;
        getBalance();
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
        tenB = new javax.swing.JButton();
        twnetyB = new javax.swing.JButton();
        fiftyB = new javax.swing.JButton();
        sendB = new javax.swing.JButton();
        returnB = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(362, 258));

        montoTF.setText("0");
        montoTF.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("NUEVO CLIENTE");

        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("* Seleccione la cantidad de dinero a acreditar oprimiendo los botones");

        jLabel2.setText("Monto");

        tenB.setText("10000");
        tenB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenBActionPerformed(evt);
            }
        });

        twnetyB.setText("20000");
        twnetyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twnetyBActionPerformed(evt);
            }
        });

        fiftyB.setText("50000");
        fiftyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyBActionPerformed(evt);
            }
        });

        sendB.setText("Enviar");
        sendB.setEnabled(false);
        sendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBActionPerformed(evt);
            }
        });

        returnB.setText("Atrás");
        returnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fiftyB)
                            .addComponent(tenB)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(twnetyB)
                                    .addGap(107, 107, 107))
                                .addComponent(montoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(returnB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sendB))))))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tenB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(twnetyB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fiftyB)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendB)
                    .addComponent(returnB))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tenBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenBActionPerformed
        sendB.setEnabled(true);
        Numero num1 = new Numero();
        Numero num2 = new Numero();
        num1.setValor(Integer.parseInt(montoTF.getText()));
        num2.setValor(10000);
        Operacion op = new Operacion();
        Numero count = op.sumar(num1,num2);
        montoTF.setText(""+(int)count.getValor());
    }//GEN-LAST:event_tenBActionPerformed

    private void twnetyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twnetyBActionPerformed
        sendB.setEnabled(true);
        Numero num1 = new Numero();
        Numero num2 = new Numero();
        num1.setValor(Integer.parseInt(montoTF.getText()));
        num2.setValor(20000);
        Operacion op = new Operacion();
        Numero count = op.sumar(num1,num2);
        montoTF.setText(""+(int)count.getValor());
    }//GEN-LAST:event_twnetyBActionPerformed

    private void fiftyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyBActionPerformed
        sendB.setEnabled(true);
        Numero num1 = new Numero();
        Numero num2 = new Numero();
        num1.setValor(Integer.parseInt(montoTF.getText()));
        num2.setValor(50000);
        Operacion op = new Operacion();
        Numero count = op.sumar(num1,num2);
        montoTF.setText(""+(int)count.getValor());
    }//GEN-LAST:event_fiftyBActionPerformed

    private void sendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBActionPerformed
        try{
           double amount = new Double(montoTF.getText());
           Actual_User.getInstance().setBalanceOnChange(amount);
           int result = tc.Consignment(user, amount);
           if(result == 0){
               JOptionPane.showMessageDialog(this, "Consignación exitosa",
                       "Trasancción exitosa",JOptionPane.INFORMATION_MESSAGE);
               principal.logout();
           }
           else if(result == -1){
               JOptionPane.showMessageDialog(this, "El monto a consignar debe ser de por lo menos $10000."
                       + " Sólo se acpetan billetes","Error en la transacción",JOptionPane.WARNING_MESSAGE);
           }
           else if(result == -2){
               JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado mientra se hacía la transacción"
                       ,"Error en la transacción",JOptionPane.ERROR_MESSAGE);
           }
       }catch(Exception ex){
           JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado mientra se hacía la transacción"
                       ,"Error en la transacció",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_sendBActionPerformed

    private void returnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBActionPerformed
        principal.newCustomerOld();
    }//GEN-LAST:event_returnBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fiftyB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField montoTF;
    private javax.swing.JButton returnB;
    private javax.swing.JButton sendB;
    private javax.swing.JButton tenB;
    private javax.swing.JButton twnetyB;
    // End of variables declaration//GEN-END:variables

    private void getBalance() {
        
    }
}