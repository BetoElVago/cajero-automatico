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
public class Saldo extends javax.swing.JPanel {

    private TransactionControl control;
    /**
     * Creates new form Login
     */
    public Saldo() {
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

        saldoTF = new javax.swing.JTextField();
        saldoT = new javax.swing.JLabel();
        saldoL = new javax.swing.JLabel();
        consultarB = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(362, 258));

        saldoTF.setEnabled(false);

        saldoT.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        saldoT.setText("SALDO");

        saldoL.setText("Su saldo es:");

        consultarB.setText("Consultar");
        consultarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consultarB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(136, 136, 136)
                            .addComponent(saldoT))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(saldoL)
                            .addGap(39, 39, 39)
                            .addComponent(saldoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saldoT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldoL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultarB)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBActionPerformed
        // TODO add your handling code here:
        getBalance();
    }//GEN-LAST:event_consultarBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultarB;
    private javax.swing.JLabel saldoL;
    private javax.swing.JLabel saldoT;
    private javax.swing.JTextField saldoTF;
    // End of variables declaration//GEN-END:variables

    private void getBalance() {
        try{
           String username = Actual_User.getInstance().getUsername();
           double balance = control.getBalance(username);
           saldoTF.setText(Double.toString(balance));
       }catch(Exception ex){
           JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado"
                       ,"Error en la consulta",JOptionPane.ERROR_MESSAGE);
       }
    }
}