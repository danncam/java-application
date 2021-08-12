/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdressBook;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dan
 */
public class FriendTest {
    
    public FriendTest() {
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
     * Test of toLine method, of class Friend.
     */
    @Test
    public void testToLine() {
        System.out.println("toLine");
        Friend instance = null;
        String expResult = "";
        String result = instance.toLine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exist method, of class Friend.
     */
    @Test
    public void testExist() {
        System.out.println("exist");
        Friend instance = null;
        boolean expResult = false;
        boolean result = instance.exist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Friend.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Friend instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class Friend.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int i = 0;
        Friend instance = null;
        instance.setID(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
