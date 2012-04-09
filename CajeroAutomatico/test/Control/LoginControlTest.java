/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LENOVO
 */
public class LoginControlTest {

    public static LoginControl login = new LoginControl();

    public LoginControlTest() {
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
     * Test of login method, of class LoginControl.
     */
    @Test
    public void testLogin() throws Exception {
        boolean expResult = true;
        assertEquals(expResult, login.login("admin", "adminadmin"));
        assertEquals(!expResult, login.login("admin", "Otracosa1"));
        assertEquals(!expResult, login.login("otracosa", "admin"));
        assertEquals(!expResult, login.login("otracosa", "Otracosa1"));
    }

}