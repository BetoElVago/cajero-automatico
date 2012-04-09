/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.PersonDao;
import Entity.Actual_User;
import Entity.Person;
import org.junit.*;
import static org.junit.Assert.*;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Laarguelless
 */
public class TransactionControlTest {

    private PersonControl personControl;
    private LoginControl loginControl;
    private TransactionControl transactionControl;
   
    private Person consUser;
    private Person retirUser;
    private final String pass = "12345";
    private final double balance = 50000;

    public TransactionControlTest() {
        personControl = new PersonControl();
        loginControl = new LoginControl();
        transactionControl = new TransactionControl();
       
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        consUser = new Person();
        consUser.setName("user1");
        consUser.setUserName("user1");
        consUser.setPassword(pass);
        consUser.setDocument("1020714608");
        consUser.setBalance(balance);
        consUser.setLastName("lastname");
        
        retirUser = new Person();
        retirUser.setName("user2");
        retirUser.setUserName("user2");
        retirUser.setPassword(pass);
        retirUser.setDocument("10207146010");
        retirUser.setBalance(balance);
        retirUser.setLastName("lastname");
        
        personControl.createUser(retirUser);
        personControl.createUser(consUser);
    }

    @After
    public void tearDown() {
        personControl.delete(retirUser.getUserName());
        personControl.delete(consUser.getUserName());
    }

    /**
     * Test of Consignment method, of class TransactionControl.
     */
    @Test
    public void testConsignment() throws Exception {
       /**
        * Entrar al sistema
        */
        loginControl.login(consUser.getUserName(), consUser.getPassword());
        
        double amount ;
        int result;
        /**
        * 1 - El monto es inferior a 10000
        */
        amount = 9999;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.Consignment();
        assertEquals(result,-1);
        
        /**
         * 2- El monto es mayor a 1000000
         */
        amount = 1000001;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.Consignment();
        assertEquals(result,-1);
        
        /**
         * 3- El monto no corresponde a billetes
         */
        amount = 15000;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.Consignment();
        assertEquals(result,-1);
        
        /**
         * 4 - El monto es correcto
         */
        amount = 20000;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.Consignment();
        assertEquals(result,0);
        
        /**
         * Salir del sistema
         */
        loginControl.Logout();
    }

    /**
     * Test of retirement method, of class TransactionControl.
     */
    @Test
    public void testRetirement() throws Exception {
      /**
       * Entrar al sistema
       */
        loginControl.login(retirUser.getUserName(),retirUser.getPassword());
        System.out.println("Login: "+ Actual_User.getInstance().getBalance());
        double amount;
        int result;
        
        /**
         * 1 - El monto es menor a 10000
         */
        amount = 9999;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.retirement();
        assertEquals(result,-1);
        
        /**
         * 2 - El monto es mayor a 400000
         */
        amount = 400001;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.retirement();
        assertEquals(result,-1); 
        
        /**
         * 3 - El monto es mayor al saldo de la cuenta. 50000 en este caso
         */
        amount = 60000;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.retirement();
        assertEquals(result,-2);
        
        /**
         * El monto es adecuado
         */
        System.out.println("com: "+Actual_User.getInstance().getBalance());
        amount = 40000;
        Actual_User.getInstance().setBalanceOnChange(amount);
        result = transactionControl.retirement();
        assertEquals(result,0);
       
        /**
         * Salir
         */
        loginControl.Logout();
        
    }
}
