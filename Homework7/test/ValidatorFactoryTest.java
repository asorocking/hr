/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samsung
 */
public class ValidatorFactoryTest {
    
    public ValidatorFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateValidator() {
        System.out.println("createValidator");
        ValidatorFactory instance = new ValidatorFactoryImpl();
        Validator expResult = null;
        Validator result = instance.createValidator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ValidatorFactoryImpl implements ValidatorFactory {

        public Validator createValidator() {
            return null;
        }
    }
    
}
