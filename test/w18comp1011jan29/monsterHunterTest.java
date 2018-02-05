/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w18comp1011jan29;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JWright
 */
public class monsterHunterTest {
    
    public monsterHunterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHunter method, of class monsterHunter.
     */
    @Test
    public void testGetHunter() {
        System.out.println("getHunter");
        monsterHunter instance = null;
        String expResult = "";
        String result = instance.getHunter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHunter method, of class monsterHunter.
     */
    @Test
    public void testSetHunter() {
        System.out.println("setHunter");
        String hunter = "";
        monsterHunter instance = null;
        instance.setHunter(hunter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonster method, of class monsterHunter.
     */
    @Test
    public void testGetMonster() {
        monsterHunter instance = new monsterHunter("Tyrell","Dragon");
        String expResult = "Dragon";
        String result = instance.getMonster();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMonster method, of class monsterHunter.
     */
    @Test
    public void testSetMonster() {
        System.out.println("setMonster");
        String monster = "";
        monsterHunter instance = null;
        instance.setMonster(monster);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forLoopExample method, of class monsterHunter.
     */
    @Test
    public void testForLoopExample() {
        System.out.println("forLoopExample");
        monsterHunter instance = null;
        instance.forLoopExample();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coolMethod method, of class monsterHunter.
     */
    @Test
    public void testCoolMethod() {
        System.out.println("coolMethod");
        String expResult = "";
        String result = monsterHunter.coolMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
