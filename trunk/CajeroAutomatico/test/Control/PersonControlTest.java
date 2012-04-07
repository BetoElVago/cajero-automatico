/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Person;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author LENOVO
 */
public class PersonControlTest {
    public static PersonControl control = new PersonControl();
    
    public PersonControlTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createperson method, of class PersonControl.
     */
    @Test
    public void testCreateperson() {
         Person person = new Person();
        
         //Normal Flow
        person.setName("Usuario Prueba");
        person.setUserName("usuario01");
        person.setDocument("1234567");
        person.setPassword("usuario01");
        person.setBalance(50000);
        assertEquals(0, control.createUser(person));
        
        //Wrong userName length
        person.setUserName("user");
        person.setDocument("1234567");
        person.setPassword("usuario01");
        assertEquals(-1, control.createUser(person));
        
        //Wrong passwrod length
        person.setUserName("usuario01");
        person.setDocument("12345678");
        person.setPassword("user");
        assertEquals(-2, control.createUser(person));
        
        //Username that already exists
        person.setUserName("usuario01");
        person.setDocument("12345678");
        person.setPassword("usuario01");
        assertEquals(-3, control.createUser(person));
        
        //Wrong document length
        person.setUserName("usuario02");
        person.setDocument("123456");
        person.setPassword("usuario01");
        assertEquals(-4, control.createUser(person));
    }

  
    /**
     * Test of updatePass method, of class PersonControl.
     */
    @Test
    public void testUpdatePass() {
        Person person = new Person();
        String username;
        String newpass;
        
        //Wrong passwrod length
        username = "usuario01";
        newpass = "user";
        assertEquals(-1, control.updatePass(username, newpass));
        
        //Normal Flow
        username = "usuario01";
        newpass = "usuario";
        assertEquals(0, control.updatePass(username, newpass));
    }

    /**
     * Test of delete method, of class PersonControl.
     */
    @Test
    public void testDelete() {
        String username;
        
        //Normal flow
        username = "usuario01";
        assertEquals(true, control.delete(username));
    }
}
