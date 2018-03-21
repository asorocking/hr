/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Samsung
 */
public class Homework7Test {

    public Homework7Test() {
    }
    
    @Before
    public void setUp(){
        
        
    }
    

    @After
    public void tearDown() {
    }
    @Before
    static ValidatorFactory createValidatorBySpecialty(String specialty) throws ValidationFailedException {
        if (specialty.equalsIgnoreCase("int")) {
            return new IntValidatorFactory();
        } else if (specialty.equalsIgnoreCase("string")) {
            return new StringValidatorFactory();
        } else {
            throw new ValidationFailedException(specialty + " is unknown specialty ");
        }
    }
    @Test
    public void testValidateInt() throws ValidationFailedException {
        String line = "";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        validator.validate(line);
        validator.validate("1");

        validator.validate("5");

        validator.validate("10");

    }

    @Test (expected = ValidationFailedException.class)
    public void testValidateIntFails() throws ValidationFailedException {
        String line = "";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        validator.validate(line);
        validator.validate("11");

    }

    @Test(expected = ValidationFailedException.class)

    public void testValidateIntFails2() throws ValidationFailedException {
String line = "";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        validator.validate(line);
        validator.validate("0");

    }

    @Test

    public void testValidateString() throws ValidationFailedException {
String line = "";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        validator.validate(line);
        
        validator.validate("Hello");
        validator.validate("Hello world, abc");
}




@Test(expected = ValidationFailedException.class)

    public void testValidateStringFails() throws ValidationFailedException {

 String line = "";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        validator.validate(line);
        validator.validate("hello");
}




@Test(expected = ValidationFailedException.class)

    public void testValidateStringFails2() throws ValidationFailedException {
String line = "";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        validator.validate(line);
        validator.validate("");
}
}
