/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Actual_User;
import Entity.Person;

/**
 *
 * @author David
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    
    private Actual_User actualUser = Actual_User.getInstance();
    private NewCustomer customer;

    public NewCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(NewCustomer customer) {
        this.customer = customer;
    }
    
    public Principal() {
        initComponents();
        inicialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        principalPanel.setBackground(new java.awt.Color(255, 255, 255));
        principalPanel.setLayout(new java.awt.BorderLayout());

        menuPanel.setBackground(new java.awt.Color(0, 0, 0));
        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicialize() {
        actualUser.setPrincipal(this);
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new Login());
        principalPanel.setVisible(true);
        this.bloqMenu();
    }
    
    public void welcome() {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new Welcome());
        principalPanel.setVisible(true);
        this.enableMenu();
    }
    
    private void bloqMenu() {
        menuPanel.setVisible(false);
    }
    
    private void enableMenu() {
        menuPanel.setVisible(false);
        menuPanel.removeAll();
        menuPanel.add(new Menu());
        menuPanel.setVisible(true);
    }
    
    public void debitar(){
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new Debitar());
        principalPanel.setVisible(true);
    }
    
    public void acreditar() {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new Acreditar());
        principalPanel.setVisible(true);
    }
    
    public void acreditar(Person user) {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new AcreditarNew(user));
        principalPanel.setVisible(true);
    }
    
    public void saldo() {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new Saldo());
        principalPanel.setVisible(true);
    }
    
    public void newCustomer() {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(new NewCustomer());
        principalPanel.setVisible(true);
    }
    
    public void logout() {
        actualUser.setNull();
        actualUser = Actual_User.getInstance();
        inicialize();
    }
    
    public void newCustomerOld() {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(customer);
        principalPanel.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel principalPanel;
    // End of variables declaration//GEN-END:variables

        
}
